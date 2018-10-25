package bot;

import java.util.Date;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GetHora extends TelegramLongPollingBot{
	
	Date relogio = new Date();
	int horaAlarme = relogio.getHours();
	int minAlarme = relogio.getMinutes();
	int min = minAlarme + 2;

	public String getBotUsername() {
		
		return "beba_agua_bot";
	}

	public void onUpdateReceived(Update update) {
		
		Date rlg = new Date();
		
		if(update.hasMessage()){
			int hora = horaAlarme;
			int minAtual = rlg.getMinutes();
			Message msg = update.getMessage();
			
			SendMessage sm1 = new SendMessage();
			
			sm1.setChatId(update.getMessage().getChatId());
			sm1.setText("Mensagem " + msg.getText());
			sm1.setText("Hora inicial: " + horaAlarme + ":" + minAlarme + "\nPróximo lembrete: " + horaAlarme + ":" + min); 
			
			if(hora == horaAlarme && minAtual == min){
				sm1.setText("Beba água!!");
				min = min + 2;
			}
			
			
			try {
				execute(sm1);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String getBotToken() {
		
		return "722460616:AAFbwJ0bYLL2egedugPlg7Zqr7UEVA3rXPs";
	}
}
