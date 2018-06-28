package test.sdc.archunit;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaMember;
import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.core.domain.properties.HasModifiers;
import com.tngtech.archunit.core.domain.properties.HasOwner;
import com.tngtech.archunit.lang.*;

import java.lang.annotation.Annotation;
import java.util.stream.StreamSupport;

import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAPackage;
import static com.tngtech.archunit.core.domain.JavaModifier.PUBLIC;
import static com.tngtech.archunit.core.domain.properties.HasModifiers.Predicates.modifier;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;

final class ArchUnitUtils {

    private ArchUnitUtils() {}

    static ClassesTransformer<JavaMethod> methods() {
        return new AbstractClassesTransformer<JavaMethod>("methods") {
            @Override
            public Iterable<JavaMethod> doTransform(final JavaClasses javaClasses) {
                return StreamSupport.stream(javaClasses.spliterator(), false)
                        .flatMap(javaClass -> javaClass.getMethods().stream())
                        .collect(toList());
            }
        };
    }

    static DescribedPredicate<? super JavaMember> areDefinedInAPackage(final String packageIdentifier) {
        return HasOwner.Functions.Get.<JavaClass>owner().is(resideInAPackage(packageIdentifier));
    }

    static DescribedPredicate<HasModifiers> arePublic() {
        return modifier(PUBLIC).as("are public");
    }

    static ArchCondition<JavaMethod> beAnnotatedWith(final Class<? extends Annotation> annotation) {
        return new ArchCondition<JavaMethod>("annotated with " + annotation) {
            @Override
            public void check(final JavaMethod method, final ConditionEvents events) {
                boolean typeMatches = method.isAnnotatedWith(annotation);
                final String message = format("%s annotated with %s",
                        method.getFullName(), method.getAnnotations().stream()
                                .map(annotation -> annotation.getType().getSimpleName())
                                .collect(toList()));
                events.add(new SimpleConditionEvent(method, typeMatches, message));
            }
        };
    }

}