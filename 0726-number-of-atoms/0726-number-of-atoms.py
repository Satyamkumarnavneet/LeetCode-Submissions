class Solution(object):
    def countOfAtoms(self, formula):
        stack = []
        atoms = {}
        i = 0
        while i < len(formula):
            c = formula[i]
            if c == "(":
                stack.append(atoms)
                atoms = {}
            elif c == ")":
                i += 1
                count = ""
                while i < len(formula) and formula[i].isdigit():
                    count += formula[i]
                    i += 1
                count = int(count) if count else 1
                prev_atoms = stack.pop()
                for atom, atom_count in atoms.items():
                    prev_atoms[atom] = prev_atoms.get(atom, 0) + atom_count * count
                atoms = prev_atoms
                continue
            else:
                atom = c
                i += 1
                while i < len(formula) and formula[i].islower():
                    atom += formula[i]
                    i += 1
                count = ""
                while i < len(formula) and formula[i].isdigit():
                    count += formula[i]
                    i += 1
                count = int(count) if count else 1
                atoms[atom] = atoms.get(atom, 0) + count
                continue
            i += 1
        result = "".join(atom + (str(count) if count > 1 else "") for atom, count in sorted(atoms.items()))
        return result
