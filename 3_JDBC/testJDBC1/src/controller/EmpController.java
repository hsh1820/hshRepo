package controller;

import java.util.ArrayList;

import model.dao.EmpDAO;
import model.vo.EMP;
import view.EmpView;

public class EmpController {
	// View ���� ���޹��� �����͸�(client request) 
	//����ó��(�����ͺ�ȯ, ���ڵ�(�����ִ°� Ǯ��� �۾�)) ���� ��
	// DAO�� �����ϴ� ���� (DB)
	
	// DAO�� ���� ���޹��� ����� ���� View(���ȭ��)�� �����Ͽ�
	// ���ڵ� �� �˸��� View�� ����(response)
	
	// DB ó�� ����� ���� View ����� ���� EmpView ��ü ����
	private EmpView view = new EmpView();
	// ����޴�, ����, ����(����) ȭ���� ����ϴ� ����
	// Run Ŭ���������� Main Menu ȭ�鸸 ���
	// EmpCon Ŭ���������� Request�� ���� ����޴�, ����, ���� ȭ�鸸 ��� 
	
	// 1. ��ü ��� ���� ��ȸ ���
	public void selectAll() {
		
		// 1_1.  View�� ��û�� DB�� �����ϰ� ����� ��ȯ ���� 
		// 		EmpDAO ��ü ����
		EmpDAO empDAO = new EmpDAO();
		
		// 1_2. DBMS ���� �� ��ü ��� ������ ��ȸ�ϰ� 
		// 		�� ����� ��ȯ�� �޼ҵ��� 
		// 		EmpDAO.selectAll() �޼ҵ� �ۼ�
		/// -------- > DB���� ó���ϴ� �� �̱� ������ EmpDAO���� ���� �����Ǿ����
		
		// 1_7. DB ���� Ȯ���� ���Ͽ� EmpDAO.selectAll() ȣ��
		ArrayList<EMP> empList = empDAO.selectAll();
		// + ���θ޴� case 1�� controller.selectAll() ȣ�� �ۼ�
		
		// 1_13. ��ȸ ����� ���� ������ View�� ����
		// 1) ��ȯ�� empList�� ����� �����Ͱ� ���� ���
		// 	  -> �ִٸ� ��ȸ�� ����� ��� ����ϴ� View �޼ҵ� ȣ��
		
		// 2) empList�� ����ְų� ��ȸ ������ ���
		// 	  -> ��ȸ ����� ���ٴ� �޼����� ����� View �޼ҵ� ȣ��
		
		if( empList != null && !empList.isEmpty() ) {
			// 1_14. ��ü ��ȸ ����� ����� View �ۼ��ϱ�
			// -> EmpView.selectAll() �޼ҵ� �ۼ�
			
			// 1_16. ��ü ��� ������ ����ϴ� View ȣ��
			view.selectAll(empList);
		}else {
			// ��ȸ ����� ���� ���
			
			// 1_17. ��ȸ �Ӹ� �ƴ϶� ó�� �۾��� ��� ���� ���ų�
			// ���ܰ� �߻��ϴ� ���
			// ���������� ������� ������ View �ۼ�
			// -> EmpView.displayError() �޼ҵ� �ۼ�
			
			// 1_19. ��ȸ ����� ���� ��� �޼����� ����ϴ� View ȣ��
			view.displayError("��ȸ ����� �����ϴ�.");
		}
		
	}
	// 2. ������� ��� ���� ��ȸ
	public void selectEmp() {
		
		// 2_1. EmpDAO ��ü ����
		EmpDAO empDAO = new EmpDAO();
		
		// 2_2. ����� �Է¹޴� View ����
		// -> EmpView.selectEmpNo() �޼ҵ� �ۼ�
		
		// 2_4. ��� �Է� View�� ȣ���Ͽ� ��ȸ�� ����� �Է¹ް� 
		// 		�� ���� ��ȯ�޾� ����
		int empNo = view.selectEmpNo();
		
		// 2_5. �Էµ� ����� �Ű������� �����Ͽ�
		// 		�ش� ����� ���� ����� ������ ��ȸ�ϴ� 
		// 		EmpDAO.selectEmp(empNo) �ۼ�
		
		// 2_13. DB���� ��ȸ�� ��� ������ ����
		EMP emp = empDAO.selectEmp(empNo);
		
		// 2_14. ��ȸ ��������� ���� View ���� ����
		if(emp != null){ // ��ȸ����� ���� ���
			// 2_15. ��� �� ���� ������ ����ϴ� View
			// empView.selectEMP() �ۼ�
		
			
			// 2_17. EmpView.selectEmp() ȣ��
			view.selectEMP(emp);
			// ���� �޴� case 2 ���� EmpController.selectEmp();
			
		}else { // ��ȸ ����� ���� ���
			// 2_18. displayError() �޼ҵ忡
			// "�ش� ����� �˻� ����� �����ϴ�." �޼��� ����
			view.displayError("�ش� ����� �˻� ����� �����ϴ�.");
			
		}
		
	}
	
	
}
