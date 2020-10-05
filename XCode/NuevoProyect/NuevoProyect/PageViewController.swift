//
//  PageViewController.swift
//  NuevoProyect
//
//  Created by Alejandro Herrera Mendoza on 19/04/20.
//  Copyright © 2020 Alejandro Herrera Mendoza. All rights reserved.
//

import UIKit

class PageViewController: UIPageViewController {
    
    private var myControllers: [UIViewController] = []

    override func viewDidLoad() {
        super.viewDidLoad()
        let myCvBlue = UIStoryboard(name: "Main", bundle: nil).instantiateViewController(identifier: "vcBlue")
        let myCvOrange = UIStoryboard(name: "Main", bundle: nil).instantiateViewController(identifier: "vcOrange")
        
        myControllers.append(myCvBlue)
        myControllers.append(myCvOrange)
        
        setViewControllers([myCvBlue], direction: .forward, animated: true, completion: nil)
        
        dataSource = self
    }
    
}
extension PageViewController: UIPageViewControllerDataSource{
    func pageViewController(_ pageViewController: UIPageViewController, viewControllerBefore viewController: UIViewController) -> UIViewController? {
        
        let index = myControllers.firstIndex(of: viewController)
        if index == 0 {
            return myControllers.last
        }
        return myControllers.first
    }
    
    func pageViewController(_ pageViewController: UIPageViewController, viewControllerAfter viewController: UIViewController) -> UIViewController? {
        
        let index = myControllers.firstIndex(of: viewController)
        if index == 0 {
            return myControllers.last
        }
        return myControllers.first
    }
}
