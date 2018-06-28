package test.sdc.archunit;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;
import test.sdc.common.LogDescription;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.all;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;
import static test.sdc.archunit.ArchUnitUtils.*;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "test.sdc.archunit")
public class ArchitectureTest {

    @ArchTest
    public static final ArchRule layer_dependencies_are_respected = layeredArchitecture()
            .as("Layer compliance")
            .layer("Controller").definedBy("test.sdc.archunit.controller..")
            .layer("Service").definedBy("test.sdc.archunit.service..")
            .layer("Adapter").definedBy("test.sdc.archunit.adapter..")
            .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
            .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller", "Adapter")
            .whereLayer("Adapter").mayNotBeAccessedByAnyLayer()
            .because("Service layer, aka Business, should not depend on other layers, which most likely require dependencies towards external systems");

    @ArchTest
    public static final ArchRule adapters_do_not_depend_on_one_another = slices()
            .matching("test.sdc.archunit.(adapter).(*)..").namingSlices("$1 '$2'")
            .should().notDependOnEachOther()
            .because("Adapters should only depend on one external system; depending on other adapters is likely to imply pulling dependencies towards other external systems");

    @ArchTest
    public static final ArchRule all_entry_points_shoud_be_annotated_with_log_description = all(methods())
            .that(areDefinedInAPackage("test.sdc.archunit.controller.."))
            .and(arePublic())
            .should(beAnnotatedWith(LogDescription.class))
            .as("Log public methods")
            .because("Forget logs on one entry point and you won't be too happy the day you realize");

}