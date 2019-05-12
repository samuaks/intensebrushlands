package open.vision.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import open.vision.app.domain.Answer;
import open.vision.app.domain.AnswerOption;
import open.vision.app.domain.AnswerOptionRepository;
import open.vision.app.domain.AnswerRepository;
import open.vision.app.domain.Question;
import open.vision.app.domain.QuestionRepository;



@SpringBootApplication
public class AppApplication {
		
	private static final Logger log = LoggerFactory.getLogger(AppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings (CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}
	
	
	@Bean
	public CommandLineRunner lukkariKysely(QuestionRepository qRepo, AnswerOptionRepository aRepo, AnswerRepository answerRepo) {
		return (args) -> {
			log.info("Please tell rosie");
//									
//			//Questions
//			//1
//			qRepo.save(new Question("Minä vuonna aloitit opintosi Haaga-Heliassa?", "monivalinta"));
//			//2
//			qRepo.save(new Question("Oletko käyttänyt Lukkarikonetta?", "monivalinta"));
//			//3
//			qRepo.save(new Question("Oletko kokenut Lukkarikoneen toimivaksi?", "monivalinta"));
//			//4
//			qRepo.save(new Question("Mitä hyvää lukkarikoneessa mielestäsi on?", "avoin"));
//			//5
//			qRepo.save(new Question("Onko sinulla parannusehdotuksia Lukkarikoneen toimintaan?", "avoin"));
//			//6
//			qRepo.save(new Question("Mikä näistä ominaisuuksista on hyödyllisin?", "monivalinta"));
//			//7
//			qRepo.save(new Question("Millä laitteella yleensä käytät Lukkarikonetta", "monivalinta"));
//			//8
//			qRepo.save(new Question("Käyttäisitkö Lukkarikonetta enemmän jos siitä olisi mobiiliversio tai sovellus?", "monivalinta"));
//			//9
//			qRepo.save(new Question("Kuinka usein tarkastelet lukujärjestystäsi Lukkarikoneesta?", "monivalinta"));
//			//10
//			qRepo.save(new Question("Haluaisitko itse vaikuttaa Lukkarikoneen ulkoasuun?", "monivalinta"));
//			//11
//		  //qRepo.save(new Question("Onko sinulla ollut ongelmia Lukkarikoneen käytössä?", "monivalinta"));
//			
//			//Answers to question 1
//			aRepo.save(new AnswerOption("2019", qRepo.findByQuestionId(1).get(0)));
//			aRepo.save(new AnswerOption("2018", qRepo.findByQuestionId(1).get(0)));
//			aRepo.save(new AnswerOption("Aiemmin", qRepo.findByQuestionId(1).get(0)));
//			
//			//Answers to question 2
//			aRepo.save(new AnswerOption("Kyllä", qRepo.findByQuestionId(2).get(0)));
//			aRepo.save(new AnswerOption("Ei", qRepo.findByQuestionId(2).get(0)));
//			
//			//Answers to question 3
//			aRepo.save(new AnswerOption("Kyllä", qRepo.findByQuestionId(3).get(0)));
//			aRepo.save(new AnswerOption("Ei", qRepo.findByQuestionId(3).get(0)));
//			aRepo.save(new AnswerOption("En osaa sanoa", qRepo.findByQuestionId(3).get(0)));
//			
//			//Answer to question 4
//			aRepo.save(new AnswerOption("", qRepo.findByQuestionId(4).get(0)));
//			
//			//Answer to question 5
//			aRepo.save(new AnswerOption("", qRepo.findByQuestionId(5).get(0)));
//			
//			//Answers to question 6
//			aRepo.save(new AnswerOption("Lukujärjestyksen tallentaminen", qRepo.findByQuestionId(6).get(0)));
//			aRepo.save(new AnswerOption("Lukujärjestyksen kasaaminen", qRepo.findByQuestionId(6).get(0)));
//			aRepo.save(new AnswerOption("Kurssin hakeminen kurssin nimellä", qRepo.findByQuestionId(6).get(0)));
//			aRepo.save(new AnswerOption("Kurssin hakeminen kurssitunnuksella", qRepo.findByQuestionId(6).get(0)));
//			aRepo.save(new AnswerOption("Kurssien hakeminen oman lukujärjestyksen tyhjiin kohtiin", qRepo.findByQuestionId(6).get(0)));
//			aRepo.save(new AnswerOption("Valmiiden lukujärjestysten etsiminen ryhmätunnuksella", qRepo.findByQuestionId(6).get(0)));
//
//			//Answers to question 7
//			aRepo.save(new AnswerOption("Tietokoneella", qRepo.findByQuestionId(7).get(0)));
//			aRepo.save(new AnswerOption("Puhelin / Tabletti", qRepo.findByQuestionId(7).get(0)));
//			aRepo.save(new AnswerOption("Molemmilla", qRepo.findByQuestionId(7).get(0)));
//			
//			//Answers to question 8
//			aRepo.save(new AnswerOption("Kyllä", qRepo.findByQuestionId(8).get(0)));
//			aRepo.save(new AnswerOption("En", qRepo.findByQuestionId(8).get(0)));
//			aRepo.save(new AnswerOption("En osaa sanoa", qRepo.findByQuestionId(8).get(0)));
//			
//			//Answers to question 9
//			aRepo.save(new AnswerOption("Päivittäin", qRepo.findByQuestionId(9).get(0)));
//			aRepo.save(new AnswerOption("Viikottain", qRepo.findByQuestionId(9).get(0)));
//			aRepo.save(new AnswerOption("Kuukausittain", qRepo.findByQuestionId(9).get(0)));
//			aRepo.save(new AnswerOption("Harvemmin", qRepo.findByQuestionId(9).get(0)));
//			aRepo.save(new AnswerOption("En koskaan", qRepo.findByQuestionId(9).get(0)));
//
//			//Answers to question 10
//			aRepo.save(new AnswerOption("Kyllä", qRepo.findByQuestionId(10).get(0)));
//			aRepo.save(new AnswerOption("En", qRepo.findByQuestionId(10).get(0)));
//			
			//Answers to question 11
//			aRepo.save(new AnswerOption("Ei", qRepo.findByQuestionId(11).get(0)));
//			aRepo.save(new AnswerOption("Kyllä, mitä", qRepo.findByQuestionId(11).get(0)));
			
			//Actual Answers
			
//			Question testQuestion = qRepo.findByQuestionId(1).get(0);
//			answerRepo.save(new Answer("Johan on ", testQuestion));
			
//			Question testQuestion2 = qRepo.findByQuestionId(2).get(0);
//			answerRepo.save(new Answer("Mamemo", testQuestion2));
			
		};
	}
}