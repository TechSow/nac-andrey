package br.com.fiap.averngers.park.bo;

import java.util.ArrayList;

import br.com.fiap.averngers.park.beans.Valet;
import br.com.fiap.averngers.park.dao.ValetDAO;

public class ValetBO {
	private ValetDAO vDao;

	public ValetBO() throws Exception {
		vDao = new ValetDAO();
	}

	public Valet getById(int id) {
		if (id == 0) {
			return null;
		}

		Valet valet = null;
		try {
			valet = vDao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				vDao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return valet;

	}

	public ArrayList<Valet> getByDay() {
		ArrayList<Valet> list = null;
		try {
			list = vDao.getAllParked();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				vDao.close();				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	
	

}
