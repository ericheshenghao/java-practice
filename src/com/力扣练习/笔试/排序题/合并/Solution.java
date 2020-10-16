package com.力扣练习.笔试.排序题.合并;

class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        mergeSort(nums,0,nums.length-1,new int[nums.length]);
        heapSort(nums);
        return nums;
    }

    private void swap(int[] nums,int ix1,int ix2){
        int temp = nums[ix1];
        nums[ix1] = nums[ix2];
        nums[ix2] = temp;
    }

    // 快速排序，把nums[left]做为pivot，安置到数组合适的位置，使其大于左边的全部元素，小于右边的全部元素
    // 时间O(nlogn)，空间O(logn)
    private void quickSort(int[] nums, int left, int right){
        if(left>=right) return;
        int p = left;//p指针指向小于等于pivot的第一个元素
        for(int i = left+1 ; i <= right ; i++){
            //如果有小于等于pivot的元素，与p+1交换(因为p+1指向的是大于pivot的第一个元素)
            if(nums[i] <= nums[left]){
                swap(nums,++p,i);
            }
        }
        //最后将left与p交换，p就是pivot的索引
        swap(nums,left,p);
        //继续排序左边和右边的区间
        quickSort(nums,left,p-1);
        quickSort(nums,p+1,right);
    }

    // 归并排序，temp为全局临时数组，这样可以避免反复开辟空间
    private void mergeSort(int[] nums, int left, int right, int[] temp){
        if(left>=right) return;
        int mid = left + (right-left)/2;
        mergeSort(nums,left,mid,temp);
        mergeSort(nums,mid+1,right,temp);
        if(nums[mid]<=nums[mid+1]) return;//如果两个区间已经有序，就不需要合并了。
        int i = left, j = mid+1, k = 0;
        while(i<=mid && j<=right) temp[k++] = nums[i]<nums[j]?nums[i++]:nums[j++];
        while(i<=mid) temp[k++] = nums[i++];
        while(j<=right) temp[k++] = nums[j++];
        System.arraycopy(temp,0,nums,left,right-left+1);
    }

    private void heapSort(int[] nums){
        //首先建立大顶堆，对于每一个非叶子节点，从下至上构建大顶堆
        for(int i = nums.length/2-1 ; i>=0 ;i--){
            adjustHeap(nums,i,nums.length-1);
        }
        //把堆顶的最大值放置到尾部，然后继续进行调整堆操作
        int end = nums.length-1;
        while(end>0){
            swap(nums,0,end);//交换头尾元素
            end--;
            adjustHeap(nums,0,end);//继续调整堆
        }

    }

    //调整节点i及其后续节点使其满足大顶堆定义，调整范围为[0,end]
    private void adjustHeap(int[] nums, int i, int end){
        int k = i;
        //如果k存在子节点
        while(k*2+1 <= end){
            int j = 2*k + 1;//j指向左子节点
            //如果右子节点存在，并且右子节点大于左子节点，那么把j指向右子节点（即j指向子节点中的较大值）
            if(j+1<=end && nums[j+1]>nums[j]){
                j++;
            }
            //如果根节点小于子节点，交换，让大的值上浮
            if(nums[k]<nums[j]){
                swap(nums,k,j);
                //交换后，由于改变了子节点，因此从子节点继续向下判断是否满足
                k = j;
            }else{
                break;
            }
        }
    }


}