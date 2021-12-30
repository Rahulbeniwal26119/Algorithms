 // insertion at right  is a ++plus operation
 // insertion at left is a --negative operation
 // deletion from right is a --negative operation 
 // deletion from left is a ++plus operation
#include<stdio.h>
#define MAX 10
int deque[MAX];
int left = -1 , right = -1;
void insert_right(int val)
{
        if((left == 0 && right == MAX-1) || left == right+1) 
        //if queue is full or left is above the right 
        {
                return ;
        }
        if(left == -1) // if dq is empty 
        {
                left = right = 0;
        }
        else 
        {
                if(right == MAX-1)  // if left is at the end of array 
                        right = 0;
                else 
                        right++;        }
        deque[right] = val;
}

void insert_left(int val)
{
        if((left== 0 && right == MAX-1) || left == right + 1)
                return;
        if(left == -1) 
                left = right = 0;
        else 
        {
                if(left == 0)
                        left = MAX-1;
                else 
                        left = left -1;
        }
        deque[left] = val;
}

int delete_left()
{
        if(left == -1)
                return;
        int val = deque[left];
        if(left == right)
        {
                left = right = -1;
        }
        else 
        {
                if(left == MAX -1 )
                        left = 0;
                else 
                        left++;
        }
}
int delete_right()
{
        if(right == -1)
                return;
        int val = deque[right];
        if(right == left)
                right = left = -1;
        else 
        {
                if(right == 0)
                        right = MAX -1 ;
                else 
                        right--;
        }
}


