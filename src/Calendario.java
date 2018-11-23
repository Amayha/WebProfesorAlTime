import processing.core.PApplet;
import processing.core.PImage;

public class Calendario {
	
	PApplet app;
	Logica log; 
	PImage rectC;
	PImage add;
	PImage mes;
	PImage aviso;
	PImage aviso2;
	PImage mes2;
	PImage evento;
	PImage fondoGris;
	PImage fondoFijo;
	Boolean diaSeleccionado;
	Boolean oprimirAgregar;
	Boolean espacioConsulta;
	Boolean reservaEspacio;
	Boolean cancelacion;
	Boolean siguiente;
	Boolean cancelar;
	Boolean guardar;
	
	public Calendario(PApplet app, Logica log) {
		
		this.app = app;
		iniVariables();
		this.log = log;
		diaSeleccionado = false;
		oprimirAgregar = false;
		espacioConsulta = false;
		reservaEspacio = false;
		cancelacion = false;
		siguiente = false;
		cancelar = false;
		guardar = false;
	}
	


	public void pintar() {
		setFont();
		pintarCalen();
		
		
		
	}

	private void pintarCalen() {
		
		app.image(rectC, 112, 121);
		app.image(add, 157,27 );
		app.image(mes, 401, 121);
		
		//paso uno : seleccionar el dia 
		if(diaSeleccionado == true) {
			app.image(mes2,401 ,121 );		
		}
		
		// paso 2 oprimir agregar a ese dia 
		if(diaSeleccionado == true && oprimirAgregar == true) {
			app.image(fondoGris,86 ,0 );	
			app.image(aviso,408 , 240);
		}
		
		// paso 3 seleccionar tipo de evento 
		
		if((espacioConsulta == true || reservaEspacio == true || cancelacion == true)&& siguiente == true) {
			app.image(fondoGris,86 ,0 );	
			app.image(aviso2,408 , 240);
		}
		
		if(cancelar == true) {
			diaSeleccionado = false; 
			siguiente = false; 
			
		}
		
		if(guardar == true) {
			app.image(fondoFijo, 0, 0);
			app.image(rectC, 112, 121);
			app.image(add, 157,27 );
			app.image(mes2,401 ,121 );
		}
	}



	public void mouse() {
		// condicion para el boton de home
				if(app.mouseX >=27 && app.mouseX <= 57 && app.mouseY >= 147 && app.mouseY <= 173 ) {
					log.setPantalla(1);
				}
		// condicion para el dia 
				if(app.mouseX >=401 && app.mouseX <= 510 && app.mouseY >= 316 && app.mouseY <= 415 ) {
					diaSeleccionado = true;
				}
		
		// condicion para el boton de agregar
				if(app.mouseX >=157 && app.mouseX <= 219 && app.mouseY >= 31 && app.mouseY <= 93 ) {
					oprimirAgregar = true;
				}
		// condicion para Espacio de consulta
				if(app.mouseX >=444 && app.mouseX <= 887 && app.mouseY >= 309 && app.mouseY <= 342 ) {
					espacioConsulta = true;
				}
				
		// condicion para reservar un espacio
				if(app.mouseX >=444 && app.mouseX <= 887 && app.mouseY >= 365 && app.mouseY <= 398 ) {
					reservaEspacio = true;
				}
				
		// condicion para cancelar clase
				if(app.mouseX >=444 && app.mouseX <= 887 && app.mouseY >= 417 && app.mouseY <= 450 ) {
					cancelacion = true;
				}
		// coloco todas las opciones de evento por separado para poder enviar los 3 tipos de mensaje 
		
		// condicion para siguiente
				if(app.mouseX >=799 && app.mouseX <= 897 && app.mouseY >= 512 && app.mouseY <= 545 ) {
					siguiente = true;
				}
				
		// condicion para siguiente
				if(app.mouseX >=712 && app.mouseX <= 783 && app.mouseY >= 518 && app.mouseY <= 837 ) {
					cancelar = true;
				}
				
		// condicion para siguiente
				if((app.mouseX >=799 && app.mouseX <= 897 && app.mouseY >= 512 && app.mouseY <= 545) && siguiente == true) {
					guardar = true;
				}
	}

	public void setFont() {
		//app.textFont(app.createFont("Roboto-Regular.tff", 160));
		app.textSize(24);
		app.fill(0);
	}
	
	
	private void iniVariables() {
		
		rectC = app.loadImage("RectangleC.png");
		add = app.loadImage("Group.png");
		mes = app.loadImage("Group 7.2.png");
		mes2 = app.loadImage("calendario2.png");
		aviso = app.loadImage("aviso1.png");
		aviso2 = app.loadImage("aviso2.png");
		fondoGris = app.loadImage("fondoGris.png");
		fondoFijo = app.loadImage("fondoFijo.png");
		evento=  app.loadImage("evento.png");
		
	}
	

}
