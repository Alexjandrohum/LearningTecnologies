//
//  UIButtonExtensions.swift
//  Calculadora-IOS
//
//  Created by Alejandro Herrera Mendoza on 20/04/20.
//  Copyright © 2020 Alejandro Herrera Mendoza. All rights reserved.
//

import UIKit

extension UIButton {
    //Borde redondo
    func round(){
        layer.cornerRadius = bounds.height / 2
        clipsToBounds = true
    }
    
    //Brillo
    func shine(){
        UIView.animate(withDuration: 0.1, animations: {
            self.alpha = 0.5
        }){(completion)in
            UIView.animate(withDuration: 0.1, animations: {
                self.alpha = 1
            })
        }
    }
    
    //Aparencia seleccion botón
    
}
