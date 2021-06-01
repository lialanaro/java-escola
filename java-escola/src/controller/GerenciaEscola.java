package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Contato;
import model.Endereco;
import model.Materia;
import model.Professor;
import model.Turma;
import util.Mensagem;
import util.Rotulo;
import util.Valida;

/**
 * Classe responsável por controlar o sistema de gerencimento para cadastro de
 * alunos, turmas, matérias e professores
 * 
 * @author Nathalia Lanaro
 * @since 23/02/2021
 */
public class GerenciaEscola {

	// declarando as listas para armazenar os conteúdos do sistema( ALUNOS,
	// PROFESSORES )
	private ArrayList<Aluno> alunos;
	private ArrayList<Professor> professores;
	private ArrayList<Materia> materias;
	private ArrayList<Turma> turmas;

	//método construtor
	public GerenciaEscola() {
		alunos = new ArrayList<Aluno>();
		professores = new ArrayList<Professor>();
		materias = new ArrayList<Materia>();
		turmas = new ArrayList<Turma>();
		menuPrincipal();
	}

	public void menuPrincipal() {
		// cadastrar materia, cadastrar professor, cadastrar aluno, cadastrar turma,
		// listar alunos, listar professores, listar turmas, consultar turma, sair
		String menu = " \n1 - CADASTRAR MATERIA" + " \n2 - CADASTRAR PROFESSOR" + " \n3 - CADASTRAR ALUNO"
				+ " \n4 - CADASTRAR TURMA" + " \n5 - LISTAR ALUNO" + " \n6 - LISTAR PROFESSOR" + " \n7 - LISTAR TURMAS"
				+ " \n8 - CONSULTAR TURMA" + "\n9 - SAIR DO SISTEMA";

		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.sistemaEcola, 0);
			}

		}
	}

	public void processamentoPrincipal(int opcao) {

		switch (opcao) {
		case 1: {
			cadastrarMateria();
			break;
		}

		case 2: {
			cadastrarProfessor();
			break;
		}

		case 3: {
			cadastrarAluno();
			break;
		}
		case 4: {
			cadastrarTurma();
			break;
		}
		case 5: {
			listarAlunos();

			break;
		}
		case 6: {
			listarProfessores();

			break;
		}
		case 7: {
			listaTurma();

			break;
		}
		case 8: {
			consultarTurma();

			break;
		}
		case 9: {
			sair();
			break;
		}

		default:
			JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.sistemaEcola, 0);
		}

	}

	// método para cadastrar materia
	public void cadastrarMateria() {
		materias.add(getMateria());
		JOptionPane.showMessageDialog(null, Mensagem.materiaCadastrada, Rotulo.cadastroMateria, 1);

	}

	// método para cadastrar prof
	public void cadastrarProfessor() {
		if (materias.size() > 0) {
			professores.add(getProfessor());
			JOptionPane.showMessageDialog(null, Mensagem.professorCadastrado, Rotulo.cadastroProfessor, 1);

		} else {
			JOptionPane.showMessageDialog(null, Mensagem.erroProfessor, Rotulo.cadastroProfessor, 2);
		}

	}

	// método para cadastrar aluno
	public void cadastrarAluno() {
		alunos.add(getAluno());
		JOptionPane.showMessageDialog(null, Mensagem.alunoCadastrado, Rotulo.cadastroAluno, 1);

	}

	// método para cadastrar turma
	public void cadastrarTurma() {
		if (professores.size() > 0 && alunos.size() > 0) {
			turmas.add(getTurma());
			JOptionPane.showMessageDialog(null, Mensagem.turmaCadastrada, Rotulo.cadastroTurmas, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.erroCadastroTurma, Rotulo.cadastroTurmas, 2);
		}
	}

	// métdo para retornar um objeto do tipo turma
	private Turma getTurma() {
		Turma turma = new Turma();

		turma.setCodigo(getCodigoTurma());
		turma.setAno(getAno());
		turma.setProfessor(getProfessorTurma());
		turma.setMateria(getMateriaTurma());
		turma.setAlunos(getAlunosTurma());

		return turma;
	}

	// listar alunos cadastrados
	public void listarAlunos() {
		String mensagem = "Alunos Cadastrados\n";
		boolean existe = false;
		for (Aluno aluno : alunos) {
			existe = true;
			mensagem += "\nCódigo" + aluno.getCodigo() + "-" + aluno.getNome();

		}

		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroAluno, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.alunoVazio, Rotulo.cadastroAluno, 2);
		}

	}

	// listar alunos cadastrados
	public void listarProfessores() {
		String mensagem = "\nProfessores Cadastrados";
		boolean existe = false;
		for (Professor professor : professores) {
			existe = true;
			mensagem += "\nCódigo" + professor.getCodigo() + "-" + professor.getNome();
		}

		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroProfessor, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.professoresVazio, Rotulo.cadastroProfessor, 2);
		}

	}

	// listar alunos cadastrados
	public void listaTurma() {
		String mensagem = "Turmas Cadastrados\n";
		boolean existe = false;
		for (Turma turma : turmas) {
			existe = true;
			mensagem += "\nCódigo" + turma.getCodigo() + "-" + turma.getAno() + "-" + turma.getMateria().getNome();

		}

		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroTurmas, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.turmasVazio, Rotulo.cadastroTurmas, 2);
		}

	}

	// metodo para consultar turma especifica
	// listar alunos cadastrados
	public void consultarTurma() {
		Turma turma = getConsultarTurma();
		String mensagem = "Detalhes da Turma\n";
		mensagem += "\n Código" + turma.getCodigo();
		mensagem += "\nAno" + turma.getAno();
		mensagem += "\nProfessor" + turma.getProfessor().getNome();
		mensagem += "\n Matérias" + turma.getMateria().getNome();
		mensagem += "\nAlunos Matriculados";
		
		for (Aluno aluno : turma.getAlunos()) {
			mensagem += "\nCódigo" + aluno.getCodigo() + "-" + aluno.getNome();
		}
												
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.consultaTurma, 1);
		

	}

	public void sair() {
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Atenção", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}

	// método para retornar os atributos (valores) do aluno
	public Aluno getAluno() {
		Aluno aluno = new Aluno();
		Endereco endereco = new Endereco();
		Contato contato = new Contato();

		aluno.setCodigo(getCodigoAluno());
		aluno.setNome(getNomeAluno());
		aluno.setCpf(getCpfAluno());
		aluno.setRg(getRgAluno());

		endereco.setLogradouro(getLogradouro());
		endereco.setNome(getNomeLogradouro());
		endereco.setNumero(getNumero());
		endereco.setComplemento(getComplemento());
		endereco.setBairro(getBairro());
		endereco.setCidade(getCidade());
		endereco.setEstado(getEstado());
		endereco.setCep(getCep());

		contato.setTelefone(getCelular());
		contato.setEmail(getEmail());

		//
		//
		//

		aluno.setEndereco(endereco);
		aluno.setContado(contato);
		return aluno;
	}

	// método para retornar os atributos (valores) do professor
	private Professor getProfessor() {// inicio do metodo
		Professor professor = new Professor();
		Endereco endereco = new Endereco();
		Contato contato = new Contato();

		professor.setCodigo(getCodigoProfessor());
		professor.setNome(getNomeProfessor());
		professor.setRg(getRgProfessor());
		professor.setCpf(getCpfProfessor());
		professor.setListaMaterias(getMaterias());

		endereco.setLogradouro(getLogradouro());
		endereco.setNome(getNomeLogradouro());
		endereco.setNumero(getNumero());
		endereco.setComplemento(getComplemento());
		endereco.setBairro(getBairro());
		endereco.setCidade(getCidade());
		endereco.setEstado(getEstado());
		endereco.setCep(getCep());

		contato.setTelefone(getCelular());
		contato.setEmail(getEmail());

		professor.setEndereco(endereco);
		professor.setContato(contato);

		professor.setSalario(getSalario());

		return professor;
	}// fim do metodo

	private Materia getMateria() {
		Materia materia = new Materia();
		materia.setCodigo(getCodigoMateria());
		materia.setNome(getNomeMateria());
		return materia;
	}

	private int getCodigoMateria() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroMateria, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroMateria, 0);
				execute = true;
			}

		}
		return codigo;
	}// fim do método

	private String getNomeMateria() {
		boolean execute = true;
		String nome = "";
		while (execute) {
			nome = JOptionPane.showInputDialog(Mensagem.informeNome);
			if (Valida.isEmptyOrNull(nome)) {
				JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Rotulo.cadastroMateria, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nome;
	}// fim do método

	private int getCodigoAluno() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroAluno, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroAluno, 0);
				execute = true;
			}

		}
		return codigo;
	}// fim do método

	private String getNomeAluno() {
		boolean execute = true;
		String nome = "";
		while (execute) {
			nome = JOptionPane.showInputDialog(Mensagem.informeNome);
			if (Valida.isEmptyOrNull(nome)) {
				JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Rotulo.cadastroAluno, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nome;
	}// fim do método

	private String getCpfAluno() {
		boolean execute = true;
		String cpf = "";
		while (execute) {
			cpf = JOptionPane.showInputDialog(Mensagem.informeCpf);
			if (Valida.isEmptyOrNull(cpf)) {
				JOptionPane.showMessageDialog(null, Mensagem.cpfVazio, Rotulo.cadastroAluno, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cpf;
	}// fim do método

	private String getRgAluno() {
		boolean execute = true;
		String rg = "";
		while (execute) {
			rg = JOptionPane.showInputDialog(Mensagem.informeRg);
			if (Valida.isEmptyOrNull(rg)) {
				JOptionPane.showMessageDialog(null, Mensagem.rgVazio, Rotulo.cadastroAluno, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return rg;
	}// fim do método

	private String getLogradouro() {
		boolean execute = true;
		String logradouro = "";
		while (execute) {
			logradouro = JOptionPane.showInputDialog(Mensagem.informeLogradouro);
			if (Valida.isEmptyOrNull(logradouro)) {
				JOptionPane.showMessageDialog(null, Mensagem.logradouroVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return logradouro;
	}// fim do método

	private String getNomeLogradouro() {
		boolean execute = true;
		String nomeLogradouro = "";
		while (execute) {
			nomeLogradouro = JOptionPane.showInputDialog(Mensagem.informeNomeLogradouro);
			if (Valida.isEmptyOrNull(nomeLogradouro)) {
				JOptionPane.showMessageDialog(null, Mensagem.nomeLogradouroVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nomeLogradouro;
	}// fim do método

	private int getNumero() {
		boolean execute = true;
		int numero = 0;
		while (execute) {
			try {
				numero = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeNumero));

				if (Valida.isIntZero(numero)) {
					JOptionPane.showMessageDialog(null, Mensagem.numeroVazio, Rotulo.cadastroEndereco, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido, Rotulo.cadastroEndereco, 0);
				execute = true;
			}

		}
		return numero;
	}// fim do método

	private String getComplemento() {
		String complemento = "";
		complemento = JOptionPane.showInputDialog(Mensagem.informeComplemento);
		return complemento;
	}// fim do método

	private String getBairro() {
		boolean execute = true;
		String bairro = "";
		while (execute) {
			bairro = JOptionPane.showInputDialog(Mensagem.informeBairro);
			if (Valida.isEmptyOrNull(bairro)) {
				JOptionPane.showMessageDialog(null, Mensagem.bairroVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return bairro;
	}// fim do método

	private String getCidade() {
		boolean execute = true;
		String cidade = "";
		while (execute) {
			cidade = JOptionPane.showInputDialog(Mensagem.informeCidade);
			if (Valida.isEmptyOrNull(cidade)) {
				JOptionPane.showMessageDialog(null, Mensagem.cidadeVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cidade;
	}// fim do método

	private String getEstado() {
		boolean execute = true;
		String estado = "";
		while (execute) {
			estado = JOptionPane.showInputDialog(Mensagem.informeEstado);
			if (Valida.isEmptyOrNull(estado)) {
				JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return estado;
	}// fim do método

	private String getCep() {
		boolean execute = true;
		String cep = "";
		while (execute) {
			cep = JOptionPane.showInputDialog(Mensagem.informeCep);
			if (Valida.isEmptyOrNull(cep)) {
				JOptionPane.showMessageDialog(null, Mensagem.cepvazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cep;
	}// fim do método

	private String getCelular() {
		boolean execute = true;
		String celular = "";
		while (execute) {
			celular = JOptionPane.showInputDialog(Mensagem.informeCelular);
			if (Valida.isEmptyOrNull(celular)) {
				JOptionPane.showMessageDialog(null, Mensagem.celularVazio, Rotulo.cadastroContato, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return celular;
	}// fim do método

	private String getEmail() {
		boolean execute = true;
		String email = "";
		while (execute) {
			email = JOptionPane.showInputDialog(Mensagem.informeEmail);
			if (Valida.isEmptyOrNull(email)) {
				JOptionPane.showMessageDialog(null, Mensagem.emailVazio, Rotulo.cadastroContato, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return email;
	}// fim do método

	private int getCodigoProfessor() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroProfessor, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroProfessor, 0);
				execute = true;
			}

		}
		return codigo;
	}// fim do método

	private String getNomeProfessor() {
		boolean execute = true;
		String nome = "";
		while (execute) {
			nome = JOptionPane.showInputDialog(Mensagem.informeNome);
			if (Valida.isEmptyOrNull(nome)) {
				JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Rotulo.cadastroProfessor, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nome;
	}// fim do método

	private String getCpfProfessor() {
		boolean execute = true;
		String cpf = "";
		while (execute) {
			cpf = JOptionPane.showInputDialog(Mensagem.informeCpf);
			if (Valida.isEmptyOrNull(cpf)) {
				JOptionPane.showMessageDialog(null, Mensagem.cpfVazio, Rotulo.cadastroProfessor, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cpf;
	}// fim do método

	private String getRgProfessor() {
		boolean execute = true;
		String rg = "";
		while (execute) {
			rg = JOptionPane.showInputDialog(Mensagem.informeRg);
			if (Valida.isEmptyOrNull(rg)) {
				JOptionPane.showMessageDialog(null, Mensagem.rgVazio, Rotulo.cadastroProfessor, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return rg;
	}// fim do método

	private ArrayList<Materia> getMaterias() {
		ArrayList<Materia> materias = new ArrayList<Materia>();
		String mensagem = "\nMaterias Cadastradas";

		for (Materia materia : this.materias) {
			mensagem += "\nCódigo" + materia.getCodigo() + " - " + materia.getNome();
		}

		boolean aux = true;
		mensagem += "\n" + Mensagem.informeCodigo;
		while (aux) {
			try {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
				materias.add(this.materias.get(codigo - 1));
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja Cadastrar outra matéria?", "Atenção",
						JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);

				if (opcao == JOptionPane.YES_OPTION) {
					aux = true;
				} else {
					aux = false;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.informeCodigo, Rotulo.cadastroProfessor, 1);
			}
		}

		return materias;

	}

	private double getSalario() {
		boolean execute = true;
		double salario = 0;
		while (execute) {
			try {
				salario = Double.parseDouble(JOptionPane.showInputDialog(Mensagem.informeSalario));

				if (Valida.isDoubleZero(salario)) {
					JOptionPane.showMessageDialog(null, Mensagem.salarioVazio, Rotulo.cadastroProfessor, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.salarioInvalido, Rotulo.cadastroProfessor, 0);
				execute = true;
			}

		}
		return salario;
	}// fim do método

	private int getCodigoTurma() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroTurmas, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurmas, 0);
				execute = true;
			}

		}
		return codigo;
	}// fim do método

	private int getAno() {
		boolean execute = true;
		int ano = 0;
		while (execute) {
			try {
				ano = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeAno));

				if (Valida.isIntZero(ano)) {
					JOptionPane.showMessageDialog(null, Mensagem.anoVazio, Rotulo.cadastroTurmas, 0);
					execute = true;
				} else {
					execute = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.anoInvalido, Rotulo.cadastroTurmas, 0);
				execute = true;
			}

		}
		return ano;
	}// fim do método

	private Professor getProfessorTurma() {
		Professor retorno = new Professor();
		String mensagem = "\nProfessores Cadastrados";

		for (Professor professor : professores) {
			mensagem += "\nCódigo" + professor.getCodigo() + " - " + professor.getNome();
		}

		mensagem += "\n" + Mensagem.informeCodigo;

		try {
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
			retorno = professores.get(codigo - 1);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Mensagem.informeCodigo, Rotulo.cadastroProfessor, 1);
		}

		return retorno;

	}

	private Materia getMateriaTurma() {
		Materia retorno = new Materia();
		String mensagem = "\nMatérias Cadastradas";

		for (Materia materia : materias) {
			mensagem += "\nCódigo" + materia.getCodigo() + " - " + materia.getNome();
		}

		mensagem += "\n" + Mensagem.informeCodigo;

		try {
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
			retorno = materias.get(codigo - 1);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Mensagem.informeCodigo, Rotulo.cadastroProfessor, 1);
		}

		return retorno;

	}

	private ArrayList<Aluno> getAlunosTurma() {
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		String mensagem = "\nAlunos Cadastrados";

		for (Aluno aluno : this.alunos) {
			mensagem += "\nCódigo" + aluno.getCodigo() + " - " + aluno.getNome();
		}

		boolean aux = true;
		mensagem += "\n" + Mensagem.informeCodigo;
		while (aux) {
			try {
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
				alunos.add(this.alunos.get(codigo - 1));
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja outro Aluno?", "Atenção",
						JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);

				if (opcao == JOptionPane.YES_OPTION) {
					aux = true;
				} else {
					aux = false;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.informeCodigo, Rotulo.cadastroTurmas, 1);
			}
		}

		return alunos;

	}

	private Turma getConsultarTurma() {
		Turma retorno = new Turma();
		String mensagem = "\nMatérias Cadastradas";

		for (Turma turma : turmas) {
			mensagem += "\nCódigo" + turma.getCodigo() + " - " + turma.getAno() + " - " + turma.getMateria();
		}

		mensagem += "\n" + Mensagem.informeCodigo;

		try {
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
			retorno = turmas.get(codigo - 1);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Mensagem.informeCodigo, Rotulo.cadastroTurmas, 1);
		}

		return retorno;

	}

}// fim da classe
