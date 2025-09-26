import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// Buka browser dan arahkan ke login page
WebUI.openBrowser('')
WebUI.maximizeWindow()
WebUI.navigateToUrl('https://sauce-demo.myshopify.com/account/login')

// Login dengan credential valid
WebUI.setText(findTestObject('Page_Login/input_Email'), 'intanfitriana@gmail.com')
WebUI.setEncryptedText(findTestObject('Page_Login/input_Password'), 'intan')
WebUI.click(findTestObject('Page_Login/button_SignIn'))

// Verifikasi berhasil login
WebUI.verifyElementPresent(findTestObject('Page_Home/icon_UserProfile'), 10)

// Navigasi ke catalog
WebUI.click(findTestObject('Page_Home/link_Catalog'))

// Tambahkan produk ke cart
WebUI.click(findTestObject('Page_Catalog/button_AddToCart_Product1'))

// Verifikasi produk masuk ke cart
WebUI.click(findTestObject('Page_Header/icon_Cart'))
WebUI.verifyElementPresent(findTestObject('Page_Cart/item_Product1'), 10)

// Tutup browser
WebUI.closeBrowser()
