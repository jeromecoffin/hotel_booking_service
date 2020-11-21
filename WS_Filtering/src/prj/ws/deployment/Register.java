package prj.ws.deployment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Register {
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
	    PreparedStatement preparedStatement = null;
	    ResultSet resultat = null;
	    try {
	        messages.add( "Connexion à la base de données..." );
	        connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
	        messages.add( "Connexion réussie !" );

	        /* Query Object Creation */
	        preparedStatement = connexion.prepareStatement( "INSERT INTO Utilisateur (email, mot_de_passe, nom, date_inscription) VALUES(?, MD5(?), ?, NOW());", Statement.RETURN_GENERATED_KEYS );
	        messages.add( "Requête préparée créée !" );
	        
	        /* Récupération des paramètres d'URL saisis par l'utilisateur */
	        String paramEmail = request.getParameter( "email" );
	        String paramMotDePasse = request.getParameter( "motdepasse" );
	        String paramNom = request.getParameter( "nom" );
	        
	        preparedStatement.setString( 1, paramEmail );
	        preparedStatement.setString( 2, paramMotDePasse );
	        preparedStatement.setString( 3, paramNom );
	       
	        int statut = preparedStatement.executeUpdate();
	        
	        messages.add( "Résultat de la requête d'insertion préparée : " + statut + "." );
	        
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
	        messages.add( "Fermeture de l'objet PreparedStatement." );
	        if ( preparedStatement != null ) {
	            try {
	                preparedStatement.close();
	            } catch ( SQLException ignore ) {
	            }
	        }
	    }

	    return messages;
	}
}


