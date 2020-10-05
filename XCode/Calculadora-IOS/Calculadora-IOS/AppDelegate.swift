//
//  AppDelegate.swift
//  Calculadora-IOS
//
//  Created by Alejandro Herrera Mendoza on 20/04/20.
//  Copyright © 2020 Alejandro Herrera Mendoza. All rights reserved.
//

import UIKit

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        // Override point for customization after application launch.
        setupview();
        return true
    }
    
    // MARK: - Private Methods
    private func setupview(){
        window = UIWindow(frame: UIScreen.main.bounds)
        let vc = HomeViewController()
        window?.rootViewController = vc
        window?.makeKeyAndVisible()
    }
}

