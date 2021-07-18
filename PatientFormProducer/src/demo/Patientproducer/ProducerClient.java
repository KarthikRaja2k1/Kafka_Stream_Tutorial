package demo.Patientproducer;



import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;


public class ProducerClient {
/// If patient in or not, uniq id, coords , if true genrate condn
	public static void main (String args[]) throws InterruptedException {
		AmbulanceInfo amb= new AmbulanceInfo();
		while(true) {
				
			amb.setVehicleId(GenerateAmbulanceInfo.generateRandomVehicleId());
			amb.setInpatient(GenerateAmbulanceInfo.generateBooleanData());
			Map<String, String> jw = GenerateAmbulanceInfo.randomLonLat(12, 15, 70, 80);
			amb.setLocation(new Location(Double.parseDouble(jw.get("J")), Double.parseDouble(jw.get("W"))));
		
			//sendDataToKafkaSingleBroker("hehe","ambulanceinfo1");
		sendDataToKafkaMultipleBroker(amb.toString(),"ambulanceinfo1",Boolean.toString(amb.isInpatient()));
		Thread.sleep(3000);
		}
	}
	
	public static void sendDataToKafkaSingleBroker(String msg, String topicName) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		Producer<String, String> producer = new KafkaProducer<String, String>(props);
		producer.send(new ProducerRecord<String, String>(topicName, "truck", msg));
		producer.close();
	}

	public static void sendDataToKafkaMultipleBroker(String msg, String topicName, String key) {
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092,localhost:9093,localhost:9094");
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		Producer<String, String> producer = new KafkaProducer<String, String>(props);
		producer.send(new ProducerRecord<String, String>(topicName, key, msg));
		producer.close();
	}

}
