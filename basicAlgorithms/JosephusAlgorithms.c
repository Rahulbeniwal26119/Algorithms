#include<stdio.h>
#include<malloc.h>
struct node
{
        int player_id;
        struct node *next;
};
struct node *start , *ptr, *new_node;
int main()
{
        int n=10 , make_eliminate = 3, i , count;
        start = malloc(sizeof(struct node));
        start->player_id = 1;
        ptr = start;
        for(i=2; i<=n; i++) // creating a circular link list 
        {
                new_node = malloc(sizeof(struct node));
                new_node->player_id = i;
                start->next = new_node;
                new_node->next = start;
                ptr = new_node;
        }
        for(count = n; count > 1; count--)
        {
                for(i = 0; i<make_eliminate-1; ++i)
                        ptr = ptr->next;
                ptr->next = ptr->next->next;
        }
        printf("%d" , ptr->player_id);
}


        
