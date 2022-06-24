package ss12_Collection_Framework.optional.thuc_hanh.cai_dat_cay_tim_kiem_cay_nhi_phan;

public class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;

    public TreeNode(E e) {
        this.element = e;
    }
}
