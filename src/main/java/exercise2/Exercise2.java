package exercise2;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class Exercise2 {
	public static void save(Classroom classroom, Path filePath)

	{
		JFileChooser choixFichier = new JFileChooser ();
		int resultat = choixFichier.showSaveDialog(null);
		if(resultat == JFileChooser.CANCEL_OPTION)
		{
			System.out.println("Création du fichier annulée.");
			return;
		}
		File nomFichier = choixFichier.getSelectedFile();

		if(nomFichier == null || nomFichier.getName().equals(""))
		{
			System.out.println("Nom de fichier incorrect.");
			return;
		}

		try
		{
		ObjectOutputStream sortie = new ObjectOutputStream(new FileOutputStream(nomFichier));
		sortie.writeObject(classroom);
		sortie.close();
		}
		catch(Exception e){ e.printStackTrace(); }
	}



	public static Classroom load(Path filePath) {
		JFileChooser choixFichier = new JFileChooser();

		int resultat = choixFichier.showOpenDialog(null);
		if (resultat == JFileChooser.CANCEL_OPTION) {
			System.out.println("Création du fichier annulée.");
		}

		File nomFichier = choixFichier.getSelectedFile();

		if (nomFichier == null || nomFichier.getName().equals("")) {
			System.out.println("Nom de fichier incorrect.");
		}

		ObjectInputStream entree = null;
		Classroom classroom = null;
		try {
			entree = new ObjectInputStream(new FileInputStream(nomFichier));
			while (true) {
				classroom = (Classroom) entree.readObject();
				System.out.println(classroom);
			}
		} catch (java.io.EOFException e) {
			System.out.println("Fin de la lecture du fichier.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				entree.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return classroom;
	}





	public static void main(String[] args) throws IOException {

		System.out.println("Bonjour");

		Teacher teacher = new Teacher("Claire", "Barnett",
			LocalDate.of(1975, 3, 7), new PhoneNumber("+32 65 123 456"),
			new Location("Ho.23", "Houdain"));
		Student[] students = {
			new Student("Jo", "Henderson", LocalDate.of(1981, 3, 8)),
			new Student("Caleb", "Stephen", LocalDate.of(1983, 5, 9)),
			new Student("Diana", "Shelton", LocalDate.of(1981, 2, 9))
		};
		Classroom classroom = new Classroom(teacher, students);

		Path filePath = Paths.get("classroom.ser");

		Classroom classroom2 = load (filePath);

		classroom2.toString();

		System.out.println("Bonjour 2");

		System.out.printf("Classroom saved to %s, size=%d bytes\n", filePath.toString(), Files.size(filePath));

		Classroom loadedClassroom = load(filePath);

		System.out.printf("Classroom loaded from %s: %s\n", filePath.toString(), loadedClassroom.toString());
	}
}
