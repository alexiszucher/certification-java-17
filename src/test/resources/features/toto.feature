# language: fr

Fonctionnalité: Augmenter le solde du compte

  Plan du Scénario: : Augmentation de mon solde
    Etant donné que j'ai un solde de <soldeInitial> €
    Quand j'ajoute <augmentation> €
    Alors mon solde est de <nouveauSolde> €

    Exemples:
      | soldeInitial | augmentation | nouveauSolde |
      | 300          | 20           | 320          |
      | 234          | 15           | 249          |
      | 84           | 5            | 89           |