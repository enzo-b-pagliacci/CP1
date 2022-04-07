package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.entity.MarcaTenis;
import br.com.fiap.entity.Tenis;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Exemplo {
public static void main(String[] args) {
		
		//Obter uma fabrica
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		
		//Obter um entity manager
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar uma Musica
		Tenis tenis = new Tenis("Air jordan 1",new GregorianCalendar(2020, Calendar.JULY, 16),"Court Purple",MarcaTenis.JORDAN,"Novo");
		
		//Instanciar uma MusicaDaoImpl
		MusicaDao dao = new MusicaDaoImpl(em);
		
		//Cadastrar
		try {
			dao.cadastrar(musica);
			dao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}

		try {
			//Pesquisar pela PK
			Musica busca = dao.pesquisar(1);
			//Exibir o nome
			System.out.println(busca.getNome());
		} catch (IdNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Atualizar o nome da musica
			musica.setNome("Kiss Kiss");
			dao.atualizar(musica);
			dao.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Remover
		try {
			dao.remover(1);
			dao.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		fabrica.close();
	}
}
