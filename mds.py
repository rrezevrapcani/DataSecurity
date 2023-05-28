output of import numpy as np
from sympy import Matrix

def get_MDS_matrices():
    # define the field
    GF = np.zeros((256,), dtype=np.uint8)
    GF[0] = 1
    for i in range(1, 256):
        GF[i] = GF[i-1] << 1
        if GF[i] & 0x100:
            GF[i] ^= 0x1d
    # generate all possible 4x4 matrices
    matrices = []
    for i in range(256):
        for j in range(i+1, 256):
            for k in range(j+1, 256):
                for l in range(k+1, 256):
                    matrix = np.array([[GF[i], GF[j], GF[k], GF[l]],
                                       [GF[l], GF[i], GF[j], GF[k]],
                                       [GF[k], GF[l], GF[i], GF[j]],
                                       [GF[j], GF[k], GF[l], GF[i]]])
                    # check if the matrix is MDS
                    if np.linalg.det(matrix) != 0 and np.linalg.det(Matrix(matrix).transpose()) != 0:
                        matrices.append(matrix)
    return matrices

# get all MDS matrices
mds_matrices = get_MDS_matrices()
print("There are", len(mds_matrices), "MDS matrices of order 4 in GF(2^8)/x^8+x^4+x^3+x+1:")
for matrix in mds_matrices:
    print(matrix)
