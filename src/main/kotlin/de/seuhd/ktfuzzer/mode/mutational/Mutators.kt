package de.seuhd.ktfuzzer.mode.mutational

import kotlin.random.Random

/**
 * Character-level mutators from The Fuzzing Book's MutationFuzzer
 * (<https://www.fuzzingbook.org/html/MutationFuzzer.html>), plus [repeatRandomCharacter]. Each
 * function applies one small edit to an input string and returns the result.
 */
internal object Mutators {
    /** Deletes one randomly chosen character. */
    fun deleteRandomCharacter(input: String, random: Random): String =
        run {
            if (input.isEmpty()) return input
            val index = random.nextInt(input.length)
            return input.removeRange(index, index + 1)
        }

    /** Inserts one character drawn uniformly from [alphabet] at a random position. */
    fun insertRandomCharacter(input: String, alphabet: List<Char>, random: Random): String =
        run {
            val char = alphabet[random.nextInt(alphabet.size)]
            val index = random.nextInt(input.length + 1)
            return input.substring(0, index) + char + input.substring(index)
        }

    /** Flips one randomly chosen low bit of one randomly chosen character. */
    fun flipRandomCharacter(input: String, random: Random): String =
        run {
            if (input.isEmpty()) return input
            val index = random.nextInt(input.length)
            val char = input[index]
            val bitToFlip = 1 shl random.nextInt(7)
            val flippedChar = char.code xor bitToFlip
            return input.substring(0, index) + flippedChar.toChar() + input.substring(index+1)
        }

    /** Repeats one randomly chosen character a random number of times in place. */
    fun repeatRandomCharacter(input: String, random: Random): String =
        run {
            if (input.isEmpty()) return input
            val index = random.nextInt(input.length)
            val char = input[index]
            val repeatCount = random.nextInt(2, 5) // Repeat the character
            return input.substring(0, index) + char.toString().repeat(repeatCount) + input.substring(index + 1)
        }
}
