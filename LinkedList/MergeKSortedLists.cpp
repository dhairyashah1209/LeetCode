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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        ListNode *res = NULL;
        ListNode *reshead = NULL;
        bool rflag = 0;
        while(1){
            int mn = INT_MAX;
            int id = -1;
            bool flag = 0;
            for(int i=0;i<lists.size();i++){
                if(lists[i]!=NULL){
                    flag = 1;
                    if(lists[i]->val < mn){
                        mn = lists[i]->val;
                        id = i;
                    }
                }
            }
            if(!flag)
                return reshead;
            if(!rflag){
                res = new ListNode(mn);
                rflag = 1;
            }
            else{
                res->next = new ListNode(mn);
                res = res->next;            
            }
            if(reshead==NULL)
                reshead = res;
            lists[id] = lists[id]->next;
        }
        return reshead;
    }
};
