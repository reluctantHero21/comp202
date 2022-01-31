## Mastermind number guessing game
Java program that asks user to guess a random 4-digit number and gives hints when digits are guessed perfectly and off place

### My code
[mastermind.java](/java/mastermind/mastermind.java)

### Instructions
Write a game called Mastermind. The rules of the games are as follows. The computer chooses a random 4 digit number with the property that no digit repeats itself, and the number can start with a 0. We’ll call such 4 digit numbers valid numbers. For example, 0462, 2930, 6103, 9183 are all valid numbers. On the other hand 1344, 213, 90234, 9999 are all invalid numbers. The user’s goal is to try to guess the valid number that the computer has chosen. The user is only allowed to provide a valid number as a guess. Once the user makes a guess, the computer will tell the user how close that guess was by giving the following information:

- the number of digits matched perfectly (i.e., in the right place),
- the number of digits that are oﬀ place.

For example, if the computer’s number is 0123, and the user’s guess is 1523, then the computer will tell the user that 2 digits are matched perfectly, and 1 digit is oﬀ place. If the user’s guess is 2039, then 0 digits are matched perfectly and 3 digits are oﬀ place. When you execute your program, the output should look like this:

```
Welcome to Mastermind.
I have a 4 digit number in mind. Can you guess it?

What is your guess?
0123 <-------- user input

perfect matches: 0 off place: 2

What is your guess?
3045 <-------- user input

perfect matches: 1 off place: 0

What is your guess?
9921 <-------- user input

This is not a valid input.

What is your guess?
3697 <-------- user input

perfect matches: 3 off place: 0

What is your guess?
3297 <-------- user input

perfect matches: 4 off place: 0

Yes! You guessed my number correctly. Well done.
```
