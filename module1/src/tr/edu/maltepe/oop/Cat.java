package tr.edu.maltepe.oop;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

class Cat {
    private String name;
    private int age;

    public Cat(String isim, int yas) {
        this.name = isim;
        this.age = yas;
    }

    public void meow() {
        System.out.println(name + " miyavlıyor...");
        sesCal("/Users/macbookair/sofware /java/project_2/Exception_Handling/Try_Catch_Lab/Cat,/my-cat-class-Mangan61./module1/src/tr/edu/maltepe/oop/cat_meowing_1_ZAj_Dgz.wav"); // Doğru dosya yolunu ekleyelim
    }

    public void bilgileriGoster() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public void sesCal(String dosyaAdi) {
        try {
            File sesDosyasi = new File(dosyaAdi);
            if (!sesDosyasi.exists()) {
                System.out.println("Ses dosyası bulunamadı!");
                return;
            }

            AudioInputStream sesAkim = AudioSystem.getAudioInputStream(sesDosyasi);
            Clip clip = AudioSystem.getClip();
            clip.open(sesAkim);
            clip.start();

            Thread.sleep(clip.getMicrosecondLength() / 1000);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
