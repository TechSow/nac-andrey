package br.com.fiap.averngers.park.bo;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import br.com.fiap.averngers.park.beans.Valet;
import br.com.fiap.averngers.park.beans.Veiculo;
import br.com.fiap.averngers.park.dao.ValetDAO;
import br.com.fiap.averngers.park.dao.VeiculoDAO;

import java.util.Date;
public class ValetBO {
	private ValetDAO vDao;
	private double PRECO_ADICIONAL, PRECO_BASE;
	private long TEMPO_MINIMO;

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
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public double calcularPagamento(Date entrada, Date saida) {
		double preco = 0.0;
		long tempoPermanecia = (saida.getTime() - entrada.getTime()) / 1000 / 60;
		long horas = tempoPermanecia / 60;
		long minutos = tempoPermanecia % 60;
		if (this.temHorasAdicionais(this.qtdeHorasAdicionais(horas))) {
			preco = this.PRECO_BASE;
			preco = preco + this.qtdeHorasAdicionais(horas) * this.PRECO_ADICIONAL;
			if (minutos > 0) {
				preco = preco + this.PRECO_ADICIONAL;
			}
		} else {
			preco = this.PRECO_BASE;
		}
		return preco;
	}

	public long qtdeHorasAdicionais(long horas) {
		return horas - this.TEMPO_MINIMO;
	}

	public boolean temHorasAdicionais(long horasAdicionais) {
		return horasAdicionais > 0;
	}
	public ArrayList<Valet> getAllParked() {
		ArrayList<Valet> list = null;
		try {
			list = vDao.getAllParked();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				vDao.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public String park(int id, Date entrada, String placa) {
		Veiculo veiculo = null;
		VeiculoDAO veiDAO = null;
		try {
			veiDAO = new VeiculoDAO();
			veiculo = veiDAO.get(placa);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				veiDAO.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		int r = 0;
		if (veiculo.getPlaca() != null) {
			Valet v = new Valet(id, entrada, veiculo);
			try {
				r = vDao.park(v);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					vDao.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} else {
			return "Cadastre o veículo antes";
		}

		if (r == 0) {
			return "Houve um problema ao gerar o valet";
		} else {
			return "Valet gerado";
		}
	}

	public String setPaymentUnpark(int id, Date saida, double preco) {
		Valet valetParked = null;
		try {
			valetParked = vDao.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				vDao.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		java.util.Date date = new java.util.Date();
		int r=0;
		double precoapagar = calcularPagamento(valetParked.getEntrada(),(java.sql.Date) date);
		try {
			r = vDao.setPaymentUnpark(id, (java.sql.Date) date, precoapagar);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				vDao.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		if(r == 0) {
			return "Certifique-se o veículo existe, pois houve um erro";
		}else {
			return "Valet gerado";
		}
	}

	

}
