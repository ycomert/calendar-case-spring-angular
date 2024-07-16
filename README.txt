17. Takvim Entegrasyonu Sistemi

Amaç: Görevlerin ve etkinliklerin takvimde görüntülendiği bir sistem oluşturmak.

Gereksinimler:
•	Kullanıcıların sisteme giriş yapabilmesi için kimlik doğrulama gereklidir.
•	Görevler ve etkinlikler takvime entegre edilmelidir.
•	Her takvim kaydı bir görev/etkinlik adı, tarih ve saat içermelidir.
•	Takvimde günlük, haftalık ve aylık görüntüleme seçenekleri bulunmalıdır.

Veri Yapısı:
•	Takvim Kayıtları: Her takvim kaydı aşağıdaki bilgileri içermelidir:
•	ID: Takvim kaydının benzersiz kimliği (otomatik olarak atanacak).
•	Görev/Etkinlik Adı: Takvimde görüntülenecek görevin veya etkinliğin adı.
•	Tarih: Görevin veya etkinliğin tarihi.
•	Saat: Görevin veya etkinliğin saati.

İşlevler:
1.	Takvime Görev/Etkinlik Ekleme:
•	Kullanıcılar görev veya etkinlik ekleyebilmelidir.
•	Eklenen görev veya etkinlik otomatik olarak takvime entegre edilmelidir.
2.	Günlük Görüntüleme:
•	Kullanıcılar takvimde günlük olarak görevleri veya etkinlikleri görüntüleyebilmelidir.
3.	Haftalık Görüntüleme:
•	Kullanıcılar takvimde haftalık olarak görevleri veya etkinlikleri görüntüleyebilmelidir.
4.	Aylık Görüntüleme:
•	Kullanıcılar takvimde aylık olarak görevleri veya etkinlikleri görüntüleyebilmelidir.

Kullanıcı Arayüzü:
1.	Görev/Etkinlik Ekleme Formu:
•	Kullanıcı, görev veya etkinlik eklemek için formu doldurur.
•	Görev/etkinlik adı, tarih ve saat girilir, ardından "Ekle" butonuna tıklanır.
2.	Takvim Görüntüleme Arayüzü:
•	Kullanıcılar takvimde günlük, haftalık veya aylık görüntüleme seçeneklerinden birini seçebilirler.
•	Seçilen görüntüleme tipine göre görevler veya etkinlikler takvimde gösterilir.

Veritabanı Tasarımı:

1. Kullanıcılar Tablosu (Users):
•	ID: Kullanıcının benzersiz kimliği (Primary Key).
•	Kullanıcı Adı: Kullanıcının kullanıcı adı veya adı.
•	E-posta: Kullanıcının e-posta adresi.

2. Görevler Tablosu (Tasks):
•	ID: Görevin benzersiz kimliği (Primary Key).
•	Kullanıcı ID: Hangi kullanıcıya ait olduğunu belirten bir referans (Foreign Key).
•	Başlık: Görevin başlığı veya adı.
•	Başlangıç Tarihi: Görevin başlangıç tarihi.
•	Bitiş Tarihi: Görevin bitiş tarihi.

3. Etkinlikler Tablosu (Events):
•	ID: Etkinliğin benzersiz kimliği (Primary Key).
•	Kullanıcı ID: Hangi kullanıcıya ait olduğunu belirten bir referans (Foreign Key).
•	Başlık: Etkinliğin başlığı.
•	Başlangıç Tarihi: Etkinliğin başlangıç tarihi.
•	Bitiş Tarihi: Etkinliğin bitiş tarihi.

