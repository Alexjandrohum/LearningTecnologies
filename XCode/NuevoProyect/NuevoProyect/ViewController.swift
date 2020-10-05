//
//  ViewController.swift
//  NuevoProyect
//
//  Created by Alejandro Herrera Mendoza on 18/04/20.
//  Copyright © 2020 Alejandro Herrera Mendoza. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var myButton: UIButton!
    @IBOutlet weak var etiqueta: UILabel!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
        etiqueta.text = "Buenos días Alexjandrohum"
        myButton.setTitleColor(.black, for: .normal)
    }


    @IBAction func cambiar(_ sender: Any) {
        etiqueta.text = "Que tal Alexjandrohum"
        print("Muy buenas")
    }
}

