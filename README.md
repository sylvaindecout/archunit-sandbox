# Introduction to ArchUnit
This project is a sandbox intended to demonstrate basic features of ArchUnit.

## Project structure
`Master` branch contains the sandbox project, with no ArchUnit magic in yet.

Examples are included step by step, in dedicated branches named `StepX`.

## Steps
### Step 1: layer check
Check that layer definition is respected. Basically, `Service` layer is expected to be depended upon, but never to depend.

### Step 2: slice check
Check that slices of `Adapter` layer, i.e. adapters, do not depend on one another.

### Step 3: method annotation check
Check that all public methods in `controller` package are annotated with AOP log capability.