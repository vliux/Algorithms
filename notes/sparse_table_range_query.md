## Range query on sparse table
```
https://www.youtube.com/watch?v=c5O7E_PDO4U&list=PLrmLmBdmIlpvyRmZhZxSMmSfAlKetBFYa
```

## 问题
给定一个数组，求其中某一个子数组的最大、最小、总和。

## 解法
假设求最小值。数组为A，则T[i, j]为从A[i]开始到A[i+2^j-1]共包含2^j个子项的子数组的最小值，则T为sparse table。
T[i,j+1]=Min(T[i,j], T[i+2^j,j])
即table中某个T的值，可以从它的左边和左下方的两个T计算得到，又因为i=0的那列值可以预先计算得到，故table中每个T值可计算。

计算子数组的最小值：
```
int minInRange(int low, int high){
    int num = high - low + 1;
    int k = log(num);
    return Min(A[T[low][k]], A[T[low + num - 2^k][k]);
}

```