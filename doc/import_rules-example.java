public class HexagonalArchitectures {
    @ArchTest
    public static final ArchRule adapters_should_not_depend_on_one_another = ...
}

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "test.sdc.archunit")
public class ArchitectureTest {
    @ArchTest
    public static final ArchRule adapters_should_not_depend_on_one_another = HexagonalArchitectures.adapters_should_not_depend_on_one_another;
}
