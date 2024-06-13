# WebScraping (with Mobile App)

![mobil](https://github.com/oktayagdag/webscraping/assets/120986651/8259adf4-2953-488c-8daf-5a8c4e0ec023)

Python Selenium modulünü kullanarak Google Trends websitesinden çektiğimiz verileri yine aynı python sayfasında otomatik olarak Firebase Realtime Database'e ye kaydedip daha sonra bu verileri Android Studio IDE'si ile bir mobil uygulamaya dönüştürdüğümüz bir Web Scraping projesi.

##	GİRİŞ
 Bu proje kapsamında, Google Trends'te listelenen günün en çok aranan kelimelerini Python ve Selenium kütüphanesi kullanarak web scraping yöntemiyle çekmek, ardından bu verileri yine aynı Python projesinde Firebase Realtime Database'e kaydetmek amaçlanmaktadır. Projenin devamında, Android Studio'da Java ve XML kullanarak bu verilerin mobil uygulama üzerinde listelenmesi hedeflenmiştir. Listelenen haberlere tıklandığında ilgili habere giderek, güncel arama trendlerini anlık olarak takip etmek ve bu verileri mobil platformlarda erişilebilir hale getirmek için kullanılabilir.

## MATERYAL YÖNTEM
Bu projede kullanılan başlıca yöntem ve araçlar aşağıda sıralanmıştır:
⦁	Python: Web scraping ve veri işleme için kullanılan programlama dili.
⦁	Firebase: Gerçek zamanlı veri tabanı olarak kullanmak için Google veritabanı.
⦁	Android Studio: Android uygulama geliştirme ortamı için IDE.
⦁	Java ve XML: Android uygulama geliştirme için kullanılan programlama dilleri.


İlk olarak, Google Trends’ten verileri çekmek için Selenium modülünü kullandık;
 
```python
chrome_path = "C:\\Users\\DevNyxen\\Desktop\\chromedriver.exe" 
options = Options()
options.headless = True  # Arka planda çalıştırma
service = Service(chrome_path)
driver = webdriver.Chrome(service=service, options=options)

# URL'ye git
url = "https://trends.google.com/trends/trendingsearches/daily?geo=TR&hl=tr"
driver.get(url)

# Sayfanın tam olarak yüklenmesini beklemek için biraz bekleme
time.sleep(5)
```

Yukarıdaki kodlarda önce Selenium’un çalışacağı Chrome Driver yolunu belirttik.  ‘headless’ modunda Chrome tarayıcısını başlattık. Devamında Chrome Driver servisi ve Selenium Web Driver’ı başlatılıyor.
Firebase tarafında ise firebase_admin modulünü ve gerekli sınıfları import ediyoruz. Kimlik doğrulama için veritabanından oluşturup indirdiğim Json dosyamızı da bildiriyoruz. Inıtıalize_app ile Firebase uygulamasını başlatıyoruz ve veritabanı URL’sini veriyoruz. Son olarak daha sonra elde edeceğimiz datayı yollayacağımız ref değişkenini tanımlayıp tablo başlık adını da belirliyoruz.








