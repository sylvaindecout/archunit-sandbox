@ArchTest
public static final ArchRule all_entry_points_shoud_be_annotated_with_log_description = all(new AbstractClassesTransformer<JavaMethod>("methods") {
        @Override
        public Iterable<JavaMethod> doTransform(final JavaClasses javaClasses) {
                return StreamSupport.stream(javaClasses.spliterator(), false)
                        .flatMap(javaClass -> javaClass.getMethods().stream())
                        .collect(toList());
        }
})
                .that(HasOwner.Functions.Get.<JavaClass>owner().is(resideInAPackage("test.sdc.archunit.controller..")))
                .and(modifier(PUBLIC).as("are public"))
                .should(new ArchCondition<JavaMethod>("annotated with " + LogDescription.class) {
                        @Override
                        public void check(final JavaMethod method, final ConditionEvents events) {
                                boolean typeMatches = method.isAnnotatedWith(LogDescription.class);
                                final String message = format("%s annotated with %s",
                                        method.getFullName(), method.getAnnotations().stream()
                                                .map(annotation -> annotation.getType().getSimpleName())
                                                .collect(toList()));
                                events.add(new SimpleConditionEvent(method, typeMatches, message));
                        }
        });
