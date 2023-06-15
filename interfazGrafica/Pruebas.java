
package interfazGrafica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import lvlup.shop.Cliente;
import lvlup.shop.Informe;
import lvlup.shop.JFondo;
import lvlup.shop.Juego;
import lvlup.shop.Politicas;
import repositorios.RepoClientes;
import repositorios.RepoInforme;
import repositorios.RepoJuegos;
import repositorios.RepoPoliticas;

/**
 * En esta clase se realizaron las pruebas correspondientes.
 * @author Marcos&&German
 */
public class Pruebas {
    //En caso de perder los datos del repositorio, volver a cargar.
   /* public static void main(String[] args) {
        Juego j1 = new Juego("Minecraft","PC", "Sandbox, Mundo Abierto", "Mojang Studios", 2011,10, 5000, "Minecraft es un videojuego de construcción, de tipo «mundo abierto» o sandbox creado originalmente por el sueco Markus Persson, ​ y posteriormente desarrollado por su empresa, Mojang");
        Juego j2 = new Juego("Fortnite","Multiplataforma", "Survival, BattleRoyale", "Epic Games", 2017, 8, 5000, "Fortnite es un videojuego del año 2017 desarrollado por la empresa Epic Games, lanzado como diferentes paquetes de software que presentan diferentes modos de juego, pero que comparten el mismo motor general de juego y las mecánicas.");
        Juego j3 = new Juego("GTA V", "Multiplataforma", "Mundo libre, Aventura", "Rockstar", 2013, 10, 5000, "" );
        Juego j4 = new Juego("Overwatch", "Multiplataforma", "Shooter", "Blizzart", 2016 , 12, 5000, "Overwatch pone a los jugadores en equipos de seis personas, con cada persona escogiendo uno de varios héroes disponibles, cada uno con movimientos y habilidades únicas. Los héroes están divididos en tres clases: Daño, Tanque y Apoyo. ");
        Juego j5 = new Juego("Battlefield", "Multiplataforma", "Accion Shooter", "Electronic Arts", 2018 , 8, 5000, "Battlefield V es un videojuego de disparos y acción bélica en primera persona​ desarrollado por DICE y distribuido por Electronic Arts. El videojuego fue lanzado el 20 de noviembre de 2018");
        Juego j6 = new Juego("God of war", "Ps4", "Accion, Aventura", "Sony", 2018,  12, 5000, "God of War es un videojuego de acción-aventura desarrollado por SCE Santa Monica Studio y publicado por Sony Interactive Entertainment. Su lanzamiento se produjo el 20 de abril de 2018, en exclusiva para la consola PlayStation 4");
        Juego j7 = new Juego("Super Mario Maker", "Nintendo", "Editor de niveles", " Nintendo", 2019 , 8, 5000, "Super Mario Maker 2 es un videojuego de plataformas y de creación de niveles, desarrollado y publicado por Nintendo para Nintendo Switch. Es la secuela de Super Mario Maker y salió a la venta el 28 de junio de 2019 en todo el mundo.");
        Juego j8 = new Juego("The witcher", "Multiplataforma", "Accion aventura", "CD Projekt", 2015 , 10, 5000, "The Witcher es una serie de videojuegos de RPG de acción y fantasía desarrollados por CD Projekt RED, basados en la saga de novelas de Geralt de Rivia, escritas por el autor polaco Andrzej Sapkowski.");
        Juego j9 = new Juego("Red dead redemption", "Multiplataforma", "Accion Aventura western", "Rockstar Studios", 2018 , 10, 5000, "Red Dead Redemption 2 es un videojuego de acción-aventura western, en un mundo abierto y en perspectiva de primera y tercera persona, ​ con componentes para un jugador y multijugador.​ Fue desarrollado por Rockstar Studios.");
        Juego j10 = new Juego("Jump force",  "Multiplataforma", "Lucha Accion", "Bandai Namco", 20 , 14, 5000, "Jump Force es un videojuego de lucha desarrollado por Spike Chunsoft y distribuido por Bandai Namco.​ El juego está protagonizado por personajes de mangas publicados en la revista Shōnen Jump.");
        Juego j11 = new Juego("Spiderman", "Ps4", "Aventura, Mundo libre", "Sony", 2018 , 10, 5000, "Spider-Man es un videojuego de acción y aventura basado en el popular superhéroe hómonimo de la editorial Marvel Comics.​ Fue desarrollado por Insomniac Games y publicado por Sony Interactive Entertainment en exclusiva para la consola PlayStation 4.​");
        Juego j12 = new Juego("Sekiro", "Multiplataforma", "Accion Avetura", "Activision", 2019 , 8, 5000, "Sekiro: Shadows Die Twice es un videojuego de acción y aventura desarrollado por From Software y distribuido por Activision.​ El juego fue lanzado el 22 de marzo de 2019 en las plataformas PlayStation 4, Xbox One y Microsoft Windows.​ ");
        Juego j13 = new Juego("Valorant",  "PC", "Shooter", "Riot", 2020 , 12, 5000, "Valorant es un videojuego de disparos en primera persona multijugador gratuito desarrollado y publicado por Riot Games. El juego se anunció por primera vez con el nombre en clave Project A en octubre de 2019. ");
        Juego j14 = new Juego("Doom Eternal",  "Multiplataforma", "Accion disparos", "Bethesda Softworks", 2020 , 10, 5000, "Doom Eternal es un videojuego de acción y disparos en primera persona desarrollado por id Software y publicado por Bethesda Softworks.​ Es el quinto título principal de la serie Doom");
        Juego j15 = new Juego("Rage 2",  "Multiplataforma", "Accion, Aventura", "Bethesda Softworks", 2019 , 10, 5000, "Rage 2 es un videojuego de disparos en primera persona desarrollado por Avalanche Studios junto con id Software y publicado por Bethesda Softworks. ");
        Juego j16 = new Juego("Cod WarZone",  "Multiplataforma", "Activision", "Activision", 2020 , 12, 5000, "Call of Duty: Warzone es un videojuego gratuito Battle Royale lanzado el 10 de marzo de 2020 para Xbox One, PlayStation 4 y Microsoft Windows como parte de la franquicia de Call of Duty. Warzone fue desarrollado por Infinity Ward y Raven Software y publicada por Activision.");
        Juego j17 = new Juego("The last of us 2", "Ps4", "Accion, Suspenso",  "Naughty Cock", 2020 , 12, 5000, "The Last of Us Part II es un videojuego desarrollado por Naughty Cock. Publicado por Sony en exclusiva para la Playstation 4 el 19 de junio de 2020.​​");
        Juego j18 = new Juego("Resident Evil 3", "Multiplataforma", "Suspenso, Accion", "CapCom", 2020 , 10, 5000, "Se trata un nueva versión del videojuego homónimo de 1999 y sigue a los personajes de Jill Valentine y Carlos Oliveira intentando sobrevivir a un apocalipsis zombi en Raccoon City mientras son perseguidos por Nemesis");
        Juego j19 = new Juego("Cyberpunk 2077",  "Multiplataforma", "Rol", "CD Project", 2020 , 0, 5000, "Cyberpunk 2077 es un futuro videojuego desarrollado y publicado por CD Projekt, que se lanzará para Microsoft Windows, PlayStation 4 y Xbox One el 19 de noviembre de 2020");
        Juego j20 = new Juego("Naruto",  "Multiplataforma", "Aventura, Lucha", "CyberConnect2", 2016 , 12, 5000, "Naruto Shippūden: Ultimate Ninja Storm 4, conocido en Japón como Naruto ultimate Storm 4, ​ es un videojuego del anime Naruto Shippūden desarrollado por CyberConnect2 para las consolas Xbox One y PlayStation 4");
       
        
        //
        ArrayList<Juego> juegos = new ArrayList();
            juegos.add(j1);
            juegos.add(j2);
            juegos.add(j3);
            juegos.add(j4);
            juegos.add(j5);
            juegos.add(j6);
            juegos.add(j7);
            juegos.add(j8);
            juegos.add(j9);
            juegos.add(j10);
            juegos.add(j11);
            juegos.add(j12);
            juegos.add(j13);
            juegos.add(j14);
            juegos.add(j15);
            juegos.add(j16);
            juegos.add(j17);
            juegos.add(j18);
            juegos.add(j19);
            juegos.add(j20);
            
            Cliente c1 = new Cliente("Juan Perez", "324532", "juan@gmail.con");
            Cliente c2 = new Cliente("Felipe Contreras","684650", "Felipe@gmail.com");
            Cliente c3 = new Cliente("Alan Britto", "685473", "Alan@gmail.com");
            Cliente c4 = new Cliente("Franco Molinas" , "365232", "Franco@gmail.com");
            Cliente c5 = new Cliente("Joel Sanabria", "352362", "Joel@gmail.com");
            Cliente c6 = new Cliente("Pedro Gonzalez", "635416", "Pedro@gmail.com");
            ArrayList<Cliente> clientes = new ArrayList();
            clientes.add(c1);
            clientes.add(c2);
            clientes.add(c3);
            clientes.add(c4);
            clientes.add(c5);
            clientes.add(c6);      
        RepoClientes repoClientes = new RepoClientes("./src/TxtRepositorios/TxTClientes.txt");  
        repoClientes.guardar(clientes);
        RepoJuegos repoJuegos = new RepoJuegos("./src/TxtRepositorios/TxTJuegos.txt"); 
        repoJuegos.guardar(juegos);
        /*RepoInforme repoInf = new RepoInforme("./src/TxtRepositorios/TxTInforme.txt");
        
        RepoPoliticas repoPol = new RepoPoliticas("./src/TxtRepositorios/TxTPoliticas.txt");
        
        /*
        *DESDE ACA LAS PRUEBAS
        */
        
        // pol = new Politicas();
        //repoPol.guardar(pol);
        
        //Para probar el carrito DESCOMENTAR LA SIG LINEA
        //CarritoUI carrito = new CarritoUI(juegos, repoClientes, repoJuegos);
        
        //Informe inf = new Informe(LocalDate.now());
        
       /* ArrayList<Informe> infos = new ArrayList<>();
        infos.add(inf);
        
        repoInf.guardar(infos);*/
        
        
        
        //Para probar devolver los juegos LA SGTE LINEA       
        //SeleccionarClienteUI devolver = new SeleccionarClienteUI(repoClientes, repoJuegos);
        
        //Si pasa algo con los repositorios LA SIGUIENTE LINEA PARA GUARDAR DE NUEVO         

        
        
        
        
        //PoliticasUI politics  = new PoliticasUI();
        
        //Probando informe
        //InformeUI informe  = new InformeUI(repoClientes,repoJuegos);
        

        
//ESTO IMPRIME LOS CLIENTES Y SI POSEEN O NO JUEGOS. 
//SOLO IMPRIME LA CLASE DE JUEG0 PERO SIRVE PARA SABER SI TIENEN JUEGOS O NO)        
     /*   for(Cliente c : repoClientes.obtener()){
            System.out.println(c.getNombreApellido()+" - "+c.getJuegos().toString());
    }
        
                
        //OTRAS COSAS
        
        
       /*JuegosUI table = new JuegosUI(repoJuegos.obtener());*/
        //JuegoUI portadaJuego = new JuegoUI(j1);
       /* JFrame ventanaPrueba = new JFrame();
        JPanel fondo = new JFondo("fondogrande.png");
        ventanaPrueba.setContentPane(fondo);       
        ventanaPrueba.setVisible(true);
        ventanaPrueba.setSize(1080, 720);
        ventanaPrueba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrueba.setIconImage(new ImageIcon("./src/images/icono.png").getImage());        
        Juego juego = new Juego("Gta V", 5);       
        ventanaPrueba.add(juego.getEtiqueta("gta.png"));
        ventanaPrueba.add(juego1.getEtiqueta("valorant.png"));*/
       
       
       
       
      /* Cliente c1 = new Cliente("Juan Perez", "324532", "juan@gmail.con");
       Cliente c2 = new Cliente("Felipe Contreras","684650", "Felipe@gmail.com");
       Cliente c3 = new Cliente("Alan Britto", "685473", "Alan@gmail.com");
       Cliente c4 = new Cliente("Franco Molinas" , "365232", "Franco@gmail.com");
       Cliente c5 = new Cliente("Joel Sanabria", "352362", "Joel@gmail.com");
       Cliente c6 = new Cliente("Pedro Gonzalez", "635416", "Pedro@gmail.com");
       //Juego juego1 = new Juego("Valorant", 5);
       RepoClientes clientesRepo = new RepoClientes("./src/TxtRepositorios/TxTClientes.txt");
       ArrayList<Cliente> clientes = new ArrayList();
       clientes.add(c1);
       clientes.add(c2);
       clientes.add(c3);
       clientes.add(c4);
       clientes.add(c5);
       clientes.add(c6);      
       clientesRepo.guardar(clientes);
       //JuegoUI JUEGO = new JuegoUI(juego1);
       ClientesUI cliente = new ClientesUI(clientesRepo.obtener());
       
    
    
    }*/

    
}
