/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/
class Solution {
public:
    Node* copyRandomList(Node* head) {
        
        if(head==NULL)
            return NULL;
        
        Node *curr = head, *temp;
        
        while(curr){
            temp = curr->next;
            curr->next = new Node(curr->val);
            curr->next->next = temp;
            curr = temp;
        }
        
        curr = head;
        
        while(curr){
            curr->next->random = curr->random ? curr->random->next : curr->random;
            curr = curr->next ? curr->next->next : curr->next;
        }
        
        Node *original = head, *copy = head->next;
        temp = copy;
        
        while(original && copy){
            original->next = original->next ? original->next->next : original->next;
            copy->next = copy->next ? copy->next->next : copy->next;
            original = original->next;
            copy = copy->next;
        }
        
        return temp;
    }
};
