/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    
    ListNode* mergeSort(ListNode* a, ListNode* b){
    
        ListNode* res = NULL;
        if(a==NULL)
            return b;
        if(b==NULL)
            return a;
        
        if(a->val <= b->val){
            res = a;
            res->next = mergeSort(a->next,b);
        }
        else{
            res = b;
            res->next = mergeSort(a,b->next);
        }
        return res;
    }
    
    ListNode* sortList(ListNode* head) {
        ListNode *slow = head;
        ListNode *fast = head;
        ListNode *pre = NULL;
        
        if(head==NULL || head->next==NULL)
            return head;
        
        while(fast && fast->next){
            pre = slow;
            slow = slow->next;
            fast = fast->next->next;
        }
        pre->next = NULL;
        
        return mergeSort(sortList(head),sortList(slow));
    }
};
