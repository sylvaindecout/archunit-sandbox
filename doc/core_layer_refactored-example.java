@ArchTest
public static final ArchRule all_entry_points_shoud_be_annotated_with_log_description = all(methods())
        .that(areDefinedInAPackage("test.sdc.archunit.controller.."))
        .and(arePublic())
        .should(beAnnotatedWith(LogDescription.class));
