import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// buka browser & ke homepage
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://sauce-demo.myshopify.com/')

// klik tombol Sign Up
WebUI.waitForElementVisible(findTestObject('page_home/btn_SignUp'), 15)
WebUI.enhancedClick(findTestObject('page_home/btn_SignUp'))

// isi form register
WebUI.waitForElementVisible(findTestObject('page_register/input_FirstName'), 15)
WebUI.setText(findTestObject('page_register/input_FirstName'), 'intan')
WebUI.setText(findTestObject('page_register/input_LastName'), 'fitriana')

// pakai email unik supaya gak bentrok kalau test diulang
String email = 'intan' + System.currentTimeMillis() + '@gmail.com'
WebUI.setText(findTestObject('page_register/input_Email'), email)

// password
WebUI.setText(findTestObject('page_register/input_Password'), 'Password123!')

// submit form
WebUI.click(findTestObject('page_register/btn_Submit'))

// kasih waktu delay 20detik untuk isi captcha manual dikasih wakt
WebUI.delay(20)

// verifikasi setelah submit (contoh: URL berubah ke /account)
//WebUI.waitForPageLoad(10)
//WebUI.verifyMatch(WebUI.getUrl(), '.account.', true)

// tutup browser
WebUI.closeBrowser()