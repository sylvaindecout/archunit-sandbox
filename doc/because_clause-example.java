@ArchTest
public static final ArchRule adapters_do_not_depend_on_one_another = slices()
        .matching("test.sdc.archunit.(adapter).(*)..").namingSlices("$1 '$2'")
        .should().notDependOnEachOther()
        .as("Adapters do not depend on one another")
        .because("Adapters should only depend on one external system; depending on other adapters is likely to imply pulling dependencies towards other external systems");
