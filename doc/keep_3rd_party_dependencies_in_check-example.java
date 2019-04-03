@ArchTest
public static final ArchRule only_adapters_pull_model_dependencies = noClasses()
        .that().resideOutsideOfPackage("test.sdc.archunit.adapter..")
        .should().accessClassesThat().resideInAnyPackage("com.fasterxml..");
