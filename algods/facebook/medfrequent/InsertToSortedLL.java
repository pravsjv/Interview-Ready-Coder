package algods.facebook.medfrequent;

import org.w3c.dom.Node;

/**
 * https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/description/
 * LeetCode: 708
 */
public class InsertToSortedLL {
    public Node insert(Node head, int insertVal) {
        // edge case
        if (head == null) {
            Node newNode = new Node(insertVal, null);
            newNode.next = newNode;
            return newNode;
        }

        Node prev = head;
        Node curr = head.next;
        boolean toInsert = false;

        do {
            if (prev.val <= insertVal && curr.val >= insertVal) {
                toInsert = true;
            } else if (prev.val > curr.val &&  (prev.val <= insertVal || curr.val >= insertVal)){
                toInsert = true;
            }

            if (toInsert) {
                prev.next = new Node(insertVal, curr);
                return head;
            }
            prev = curr;
            curr = curr.next;
        } while (prev != head);

        prev.next = new Node(insertVal, curr);
        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    };
}
