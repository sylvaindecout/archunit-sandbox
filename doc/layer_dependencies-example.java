@ArchTest
public static final ArchRule layer_dependencies_are_respected = layeredArchitecture()
    .layer("Controller").definedBy("test.sdc.archunit.controller..")
    .layer("Service").definedBy("test.sdc.archunit.service..")
    .layer("Adapter").definedBy("test.sdc.archunit.adapter..")
    .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
    .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller", "Adapter")
    .whereLayer("Adapter").mayNotBeAccessedByAnyLayer();
