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
	    String url = "jdbc:mysql://localhost:3306/reservation_hotel";
	    String utilisateur = "jerome";
	    String motDePasse = "poulou";
	    Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultat = null;
	    try {
	        messages.add( "Connexion à la base de données..." );
	        connexion = DriverManager.getConnection( url, utilisateur, motDePasse );
	        messages.add( "Connexion réussie !" );
	        
	        /* Création de l'objet gérant les requêtes préparées */
	        preparedStatement = connexion.prepareStatement( "SELECT id, nom, nb_rooms_total, nb_rooms_available FROM hotel;" );
	        messages.add( "Requête préparée créée !" );

	        /* Exécution d'une requête de lecture */
	        resultat = preparedStatement.executeQuery();
	        //messages.add( "Requête \"SELECT id, email, mot_de_passe, nom FROM Utilisateur;\" effectuée !" );

	 
	        /* Getting data from query */
	        while ( resultat.next() ) {
	            int idHotel = resultat.getInt( "id" );
	            String nomHotel = resultat.getString( "nom" );
	            int nb_rooms_total = resultat.getInt("nb_rooms_total");
	            int nb_rooms_available = resultat.getInt("nb_rooms_available" );
	            //String nomUtilisateur = resultat.getString( "nom" );
	            /* Format data for JSP */
	            messages.add( "Données retournées par la requête : id = " + idHotel + ", hotel = " + nomHotel
	                    + ", nb rooms available = "
	                    + nb_rooms_available 
	                    + ", nb rooms total ="
	                    + nb_rooms_total + "." );
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
	        messages.add( "Fermeture de l'objet PreparedStatement." );
	        if ( preparedStatement != null ) {
	            try {
	                preparedStatement.close();
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


