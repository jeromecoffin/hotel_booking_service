package prj.ws.deployment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Availability {
	private List<String> messages = new ArrayList<String>();
	
	public List<String> executerTests( HttpServletRequest request ) {
		
	    /* Loading JDBC Driver for MySQL*/
	    try {
	        messages.add( "Chargement du driver..." );
	        Class.forName( "com.mysql.jdbc.Driver" );
	        messages.add( "Driver chargé !" );
	    } catch ( ClassNotFoundException e ) {
	        messages.add( "Erreur lors du chargement : le driver n'a pas été trouvé dans le classpath ! <br/>"
	                + e.getMessage() );
	    }

	    /* Database connection */
	    String url = "jdbc:mysql://localhost:3306/bdd_test";
	    String utilisateur = "jerome";
	    String motDePasse = "poulou";
	    Connection connexion = null;
	    Statement statement = null;
	    ResultSet resultat = null;
	    try {
	        messages.add( "Connexion à la base de données..." );
	        connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
	        messages.add( "Connexion réussie !" );

	        /* Query Object Creation */
	        statement = connexion.createStatement();
	        messages.add( "Objet requête créé !" );

	        /* Select query execution */
	        resultat = statement.executeQuery( "SELECT id, email, mot_de_passe, nom FROM Utilisateur;" );
	        messages.add( "Requête \"SELECT id, email, mot_de_passe, nom FROM Utilisateur;\" effectuée !" );
	 
	        /* Getting data from query */
	        while ( resultat.next() ) {
	            int idUtilisateur = resultat.getInt( "id" );
	            String emailUtilisateur = resultat.getString( "email" );
	            String motDePasseUtilisateur = resultat.getString( "mot_de_passe" );
	            String nomUtilisateur = resultat.getString( "nom" );
	            /* Format data for JSP */
	            messages.add( "Données retournées par la requête : id = " + idUtilisateur + ", email = " + emailUtilisateur
	                    + ", motdepasse = "
	                    + motDePasseUtilisateur + ", nom = " + nomUtilisateur + "." );
	        }
	    } catch ( SQLException e ) {
	        messages.add( "Erreur lors de la connexion : <br/>"
	                + e.getMessage() );
	    } finally {
	        messages.add( "Fermeture de l'objet ResultSet." );
	        if ( resultat != null ) {
	            try {
	                resultat.close();
	            } catch ( SQLException ignore ) {
	            }
	        }
	        messages.add( "Fermeture de l'objet Statement." );
	        if ( statement != null ) {
	            try {
	                statement.close();
	            } catch ( SQLException ignore ) {
	            }
	        }
	        messages.add( "Fermeture de l'objet Connection." );
	        if ( connexion != null ) {
	            try {
	                connexion.close();
	            } catch ( SQLException ignore ) {
	            }
	        }
	    }

	    return messages;
	}
}

