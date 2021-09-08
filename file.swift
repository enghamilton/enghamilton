//Swift <5, Swift 5 characters becomes obsolete use String instead of
let str = "aabbcsdfaewdsrsfdeewraewd"

let dict = str.characters.reduce([:]) { (d, c) -> Dictionary<Character,Int> in
    var d = d
    let i = d[c] ?? 0
    d[c] = i+1
    return d
}
print(dict)

//https://stackoverflow.com/questions/34371495/counting-different-characters-in-swift
