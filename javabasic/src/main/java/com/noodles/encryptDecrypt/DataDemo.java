package com.noodles.encryptDecrypt;

import com.noodles.encryptDecrypt.client.ApiClient;
import com.noodles.encryptDecrypt.request.InterfaceUploadRequest;
import com.noodles.encryptDecrypt.request.InterfaceUploadValidationRequest;
import com.noodles.encryptDecrypt.response.InterfaceUploadResponse;
import com.noodles.encryptDecrypt.response.InterfaceUploadValidationResponse;
import com.noodles.encryptDecrypt.util.RSAUtil;

import java.util.ArrayList;
import java.util.List;

/**
* @Description:  接口数据加解密示例
* @Author: Eric
* @Date: 2019/6/17 18:13
*/
public class DataDemo {

	public static void main(String args[]) throws Exception {
		// 接口方式上报的客户端代码
		//interfaceUploadClient();

		// 接口方式上报的客户端本地测试代码
		interfaceUploadValidationClient();
	}

	// 接口方式上报的客户端代码
	public static void interfaceUploadClient() throws Exception {
		// RSA公钥文件路径
		String RSA_PUBLIC_KEY = "d:/文件加解密例子/rsa_public_key.pem";

		InterfaceUploadRequest req = new InterfaceUploadRequest();
		List<String> datas = new ArrayList<String>();
		String name = "田加";
		datas.add(name);
		// 设置待加密的原始数据集合
		req.setData(datas);
		ApiClient client = new ApiClient();
		// 初始化设置RSA公钥
		client.init(RSAUtil.readRSAPublicKey(RSA_PUBLIC_KEY));
		// 执行加密操作
		InterfaceUploadResponse response = client.execute(req);
		if (response.isSuccess) {
			List<String> data = response.getEncryptData();
			for (int i = 0; i < data.size(); i++) {
				System.out.println(data.get(i));
			}
			System.out.println("encrypt success;encrypt data = " + response.getEncryptData());
		} else {
			System.out.println("encrypt fail;errorMessage = " + response.getErrorMessage());
		}
	}

	// 接口方式上报的客户端本地测试代码
	public static void interfaceUploadValidationClient() throws Exception {
		// RSA私钥文件路径
		String RSA_PRIVATE_KEY = "d:/文件加解密例子/rsa_private_key.pem";

		InterfaceUploadValidationRequest req = new InterfaceUploadValidationRequest();
		List<String> datas = new ArrayList<String>();
		String name = "QB2Iwwu3SkFl82REi1Bt/csIz9hL8S1Ju7CWmlEW9eChidiKKYv4vDuMIireBWuGAmqbN6Kwxix8ySxVd9UY8rA679EVBycFDqHStnZSj/0Hs1uorP/M+ikbCtERT9PeiPia3M3RO8Vez8O+ho8hPWiPdchCvpKofNEwHGRWBEs=";// 加密后的密文
		datas.add(name);
		// 设置待解密的密文数据集合
		req.setData(datas);
		ApiClient client = new ApiClient();
		// 初始化设置RSA私钥
		client.init(RSAUtil.readRSAPrivateKey(RSA_PRIVATE_KEY));
		// 执行解密操作
		InterfaceUploadValidationResponse response = client.execute(req);
		if (response.isSuccess) {
			List<String> data = response.getDecryptData();
			for (int i = 0; i < data.size(); i++) {
				System.out.println(data.get(i));
			}
			System.out.println("decrypt success;decrypt data = " + response.getDecryptData());
		} else {
			System.out.println("decrypt fail;errorMessage = " + response.getErrorMessage());
		}
	}
}
