# Fuzzing report: iase26 Assignment 04

Name(s) and student ID: Adrienne Grapa 4759958 & Mirza Mohammad Faiq Baig 4767143

## Platform tested

Windows 11 x64

## Exercise 1: mutational fuzzer

The crash exit codes you found. For each exit code, give one representative input (or how to
generate it). Crashing inputs are grouped under `output/crashes/exit<code>/`, so the exit code is the
directory name. One representative per exit code is enough.

1. exit-1073740940

`greting="hello world"
words=["a", "b", "c"]
matrix=[["a", "b"], ["c",, "d"]]`

2. exit-1073741819
`input : greeeeting="hello world
words=["a", "b", "b"]
matri=[["a", "b"], ["c", "d"]]`

## Exercise 2: grammar-based fuzzer

Which crash does the grammar-based fuzzer reach? Why can neither a mutational nor a lexical
(regular) fuzzer reach it?
