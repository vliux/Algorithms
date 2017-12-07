package com.leetcode;

/**
 * 1. Add to stack if current value >= top of stack
 * 2. otherwise kepp removing from stack till a num which <= current is found
 * 3. calculate area every time you remove:
 *    ci = stack.pop()
 *    if(stack is empty)
 *        area = input[ci] * i
 *    else
 *        area = input[ci] * (i - stack.top - 1)
 *
 *    in the loop of pushing to stack, i = 0, 1, 2, ..., input.len-1
 *    int the loop of poping from stack, i = input.len
 */
public class MaxRectangleInHistogram {
}
