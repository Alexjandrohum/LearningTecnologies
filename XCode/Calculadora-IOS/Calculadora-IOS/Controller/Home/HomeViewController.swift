//
//  HomeViewController.swift
//  Calculadora-IOS
//
//  Created by Alejandro Herrera Mendoza on 20/04/20.
//  Copyright © 2020 Alejandro Herrera Mendoza. All rights reserved.
//

import UIKit

final class HomeViewController: UIViewController {
    
    //Numbers
    @IBOutlet weak var number0: UIButton!
    @IBOutlet weak var number1: UIButton!
    @IBOutlet weak var number2: UIButton!
    @IBOutlet weak var number3: UIButton!
    @IBOutlet weak var number4: UIButton!
    @IBOutlet weak var number5: UIButton!
    @IBOutlet weak var number6: UIButton!
    @IBOutlet weak var number7: UIButton!
    @IBOutlet weak var number8: UIButton!
    @IBOutlet weak var number9: UIButton!
    @IBOutlet weak var decimal: UIButton!
    //Symbols
    @IBOutlet weak var symbolAc: UIButton!
    @IBOutlet weak var symbolMoreMenius: UIButton!
    @IBOutlet weak var symbolPorcentual: UIButton!
    @IBOutlet weak var symbolDivider: UIButton!
    @IBOutlet weak var symbolMult: UIButton!
    @IBOutlet weak var symbolMenius: UIButton!
    @IBOutlet weak var symbolPlus: UIButton!
    @IBOutlet weak var symbolEquals: UIButton!
    //Label
    @IBOutlet weak var labelResult: UILabel!
    
    //Variables
    private var total: Double = 0 //total
    private var temp: Double = 0 //valor por pantalla
    private var operating = false //indicador si se ha seleccionado un operador
    private var decimall = false //indicar si el valor es decimal
    private var operation: OperationType = .none //operacion actual
    
    // MARK - Constantes
    private enum OperationType{
        case none, addiction, substraction, multiplication, division, porcent
    }
    
    // Formateo de valores auxiliar
    private let auxFormatter: NumberFormatter = {
        let formatter = NumberFormatter()
        let locale = Locale.current
        formatter.groupingSeparator = ""
        formatter.decimalSeparator = locale.groupingSeparator
        formatter.numberStyle = .decimal
        return formatter
    }()
    
    // Formateo de valores por pantalla por defecto
    private let printFormatter: NumberFormatter = {
        let formatter = NumberFormatter()
        let locale = Locale.current
        formatter.groupingSeparator = locale.groupingSeparator
        formatter.decimalSeparator = locale.decimalSeparator
        formatter.numberStyle = .decimal
        formatter.maximumIntegerDigits = 9
        formatter.minimumFractionDigits = 0
        formatter.maximumIntegerDigits = 8
        return formatter
    }()
    
    // MARK - Constantes
    private let kDecimalSeparator = Locale.current.decimalSeparator!
    private let kMaxLength = 9
    private let kMaxValue: Double = 999999999
    private let kMinValue: Double = 0.00000001
    
    // MARK - Inicialization
    
    init() {
        super.init(nibName: nil, bundle: nil)
    }
    
    required init?(coder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }
    
    // MARK - Life Cycle

    override func viewDidLoad() {
        super.viewDidLoad()
        
        number0.round()
        number1.round()
        number2.round()
        number3.round()
        number4.round()
        number5.round()
        number6.round()
        number7.round()
        number8.round()
        number9.round()
        
        symbolAc.round()
        symbolMult.round()
        symbolPlus.round()
        symbolEquals.round()
        symbolMenius.round()
        symbolMoreMenius.round()
        symbolPorcentual.round()
        symbolDivider.round()
        decimal.round()

        decimal.setTitle(kDecimalSeparator, for: .normal)
        result()
    }
    
    //Actions Symbols
    
    @IBAction func actionAC(_ sender: UIButton) {
        clear()
        sender.shine()
    }
    @IBAction func actionPlusMenious(_ sender: UIButton) {
        temp = temp * (-1)
        labelResult.text = printFormatter.string(from: NSNumber(value: temp))
        sender.shine()
    }
    @IBAction func actionPorcent(_ sender: UIButton) {
        if operation != .porcent {
            result()
        }
        operating = true
        operation = .porcent
        result()
        sender.shine()
    }
    @IBAction func actionDivider(_ sender: UIButton) {
        result()
        operating = true
        operation = .division
        sender.shine()
    }
    @IBAction func actionMult(_ sender: UIButton) {
        result()
        operating = true
        operation = .multiplication
        sender.shine()
    }
    @IBAction func actionMenious(_ sender: UIButton) {
        result()
        operating = true
        operation = .substraction
        sender.shine()
    }
    @IBAction func actionPlus(_ sender: UIButton) {
        result()
        operating = true
        operation = .addiction
        sender.shine()
    }
    @IBAction func actionEquals(_ sender: UIButton) {
        result()
        sender.shine()
    }
    @IBAction func actionPoint(_ sender: UIButton) {
        let currentTemp = auxFormatter.string(from: NSNumber(value: temp))!
        if !operating && currentTemp.count >= kMaxLength {
            return
        }
        labelResult.text = labelResult.text! + kDecimalSeparator
        decimall = true
        sender.shine()
    }
    // Actions Numbers
    @IBAction func numberAction(_ sender: UIButton) {
        symbolAc.setTitle("C", for: .normal)
        
        var currentTemp = auxFormatter.string(from: NSNumber(value: temp))!
        if !operating && currentTemp.count >= kMaxLength {
            return
        }
        
        //Hemos seleccionado una operacion
        if operating {
            total = total == 0 ? temp : total
            labelResult.text = ""
            currentTemp = ""
            operating = false
        }
        
        //Hemos seleccionado decimales
        if decimall {
            currentTemp = "\(currentTemp)\(kDecimalSeparator)"
            decimall = false
        }
        
        let number = sender.tag
        temp = Double(currentTemp + String(number))!
        labelResult.text = printFormatter.string(from: NSNumber(value: temp))
        
        sender.shine()
    }
    
    //limpia los valores
    private func clear(){
        operation = .none
        symbolAc.setTitle("AC", for: .normal)
        if temp != 0{
            temp = 0
            labelResult.text = "0"
        }else{
            total = 0
            result()
        }
    }
    
    private func result(){
        switch operation {
        case .none:
            //No realizará nada
            break
        case .addiction:
            total = total + temp
            break
        case .substraction:
            total = total - temp
            break
        case .multiplication:
            total = total * temp
            break
        case .division:
            total = total / temp
            break
        case .porcent:
            temp = temp / 100
            total = temp
            break
        }
        
        //Formateo en pantalla
        if total <= kMaxValue || total >= kMinValue {
            labelResult.text = printFormatter.string(from: NSNumber(value: total))
        }
        print("TOTAL: \(total)")
    }
    
    //Muestra de forma visual la operacion seleccionada
    private func selectVisualOperaction(){
        if !operating {
            switch operation {
            case .none, .porcent:
                break
            case .addiction:
                break
            case .substraction:
                break
            case .multiplication:
                break
            case .division:
                break
           
            }
        }
    }
}
