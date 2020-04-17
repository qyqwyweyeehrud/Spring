package aop_anno;

public class BoardDao implements Dao {

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("Board select.............");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("Board Insert.............");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Board delete.............");
	}

	@Override
	public void modify() {
		// TODO Auto-generated method stub
		System.out.println("Board modify.............");
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		System.out.println("Board view.............");
	}

}
