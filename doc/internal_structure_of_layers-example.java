@ArchTest
public static final ArchRule adapters_do_not_depend_on_one_another = slices()
        .matching("test.sdc.archunit.(adapter).(*)..").namingSlices("$1 '$2'")
        .ignoreDependency("test.sdc.archunit.adapter.*..", "test.sdc.archunit.adapter.common..")
        .should().notDependOnEachOther();
