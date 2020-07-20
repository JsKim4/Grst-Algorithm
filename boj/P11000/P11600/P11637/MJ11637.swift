//
//  main.swift
//  RSP
//
//  Created by 임명준 on 2020/07/19.
//  Copyright © 2020 임명준. All rights reserved.
//

import Foundation


func main(){
    let decoCnt: Int = Int(readLine()!)!
    if decoCnt > 0 && decoCnt < 100001{
        let value = readLine()!.split(separator: " ").map(){
            String($0)
        }
        let normalValue = readLine()!
        if normalValue.count == decoCnt{
            var compareValue = ""
            for i in value.enumerated(){
                compareValue += configureNumToUniCode(Int(i.element)!)
            }
            let compareValues = compareValue.sorted()
            let normalValues = normalValue.sorted()
            
            if compareValues == normalValues{
                print("y")
            }else{
                print("n")
            }
        }
    }
   

}
func configureNumToUniCode(_ num: Int)-> String{
    switch num {
    case 0: return " "
    case 1...26:
        if let value = UnicodeScalar(num+64){
            return String(value)
        }
    case 27...52:
        if let value = UnicodeScalar(num+70){
            return String(value)
        }
    default:
        print("test")
        
    }
    return ""
    
}

main()
