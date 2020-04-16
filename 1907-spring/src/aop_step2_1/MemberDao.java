package aop_step2_1;

public class MemberDao implements Dao {

	@Override
	public void select() {
		// TODO Auto-generated method stub
		System.out.println("Member select.............");
	}

	@Override
	public void insert() {
		// TODO Auto-generated method stub
		System.out.println("Member insert.............");
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("Member delete.............");
	}

	@Override
	public void modify() {
		// TODO Auto-generated method stub
		System.out.println("Member modify.............");
	}

	@Override
	public void view() {
		// TODO Auto-generated method stub
		System.out.println("Member view.............");
	}

}
